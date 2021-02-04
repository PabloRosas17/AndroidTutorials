/*
 * Copyright (c) 2020 PabloRosas17 @ https://github.com/PabloRosas17
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package coffee.flavors.androidtutorials.ub.controller

import coffee.flavors.androidtutorials.ub.model.StartBakeCase
import coffee.flavors.androidtutorials.ub.model.StartCheckCase
import coffee.flavors.androidtutorials.ub.model.StartEndCase
import coffee.flavors.androidtutorials.ub.model.StartUseCase
import coffee.flavors.androidtutorials.ub.model.states.UiStates
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_ERROR
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_PROCESSING
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S0
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S1
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S2
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S3
import coffee.flavors.androidtutorials.ub.views.actions.UiActions
import io.reactivex.rxkotlin.plusAssign
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author, evolandlupiz
 * @date, 3/5/2020
 * @property, AndroidTutorials
 * @purpose, State, Logic, and Initialization.
 */

/**
 * ViewModel used to determine state, logic, and perform initialization on @see [binder].
 * @param state the initial state of the state machine.
 */
class ViewModelUb(state: UiStates?): BaseViewModel<UiActions,UiStates>() {

    /**
     * Holds a reference to the initial state this view model (reused) will act upon.
     * @return UiState.
     */
    override var initialState= state ?: UiStates(isError = true)

    /**
     * Extensive property used to determine the new state and it's changes.
     * @return Reducer<S,C>.
     */
    private val reducer: Reducer<UiStates, UiChanges> = { state, change ->
        when(change){
            is UiChanges.Start -> state.copy(
                s0Start = true, s1Bake = false, s2Check = false, s3End = false,
                isIdle = false, isProcessing = false, isError = false
            )
            is UiChanges.Bake -> state.copy(
                s0Start = false, s1Bake = true, s2Check = false, s3End = false,
                isIdle = false, isProcessing = false, isError = false
            )
            is UiChanges.Check -> state.copy(
                s0Start = false, s1Bake = false, s2Check = true, s3End = false,
                isIdle = false, isProcessing = false, isError = false
            )
            is UiChanges.End -> state.copy(
                s0Start = false, s1Bake = false, s2Check = false, s3End = true,
                isIdle = false, isProcessing = false, isError = false
            )
            is UiChanges.Idle -> state.copy(
                s0Start = false, s1Bake = false, s2Check = false, s3End = false,
                isIdle = true, isProcessing = false, isError = false
            )
            is UiChanges.Processing -> state.copy(
                s0Start = false, s1Bake = false, s2Check = false, s3End = false,
                isIdle = false, isProcessing = true, isError = false
            )
            is UiChanges.Error -> state.copy(
                s0Start = false, s1Bake = false, s2Check = false, s3End = false,
                isIdle = false, isProcessing = false, isError = true
            )
        }
    }

    /**
     * initialization after primary constructor is resolved
     * , fire the binder function when view model is ready.
     */
    init {
        this.binder()
    }

    /**
     * Convert actions to states, uses rx techniques to map new states and deal with logic.
     */
    private fun binder() {
        val loadStartChanged = actions.ofType(UiActions.Start::class.java)
            .switchMap {
                StartUseCase().start()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<UiChanges> { UiChanges.Start(USE_CASE_S0) }
                    .onErrorReturn { UiChanges.Error(USE_CASE_ERROR) }
                    .startWith(UiChanges.Processing(USE_CASE_PROCESSING))
            }
        val loadBakeChanged = actions.ofType(UiActions.Bake::class.java)
            .switchMap {
                StartBakeCase().bake()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<UiChanges> { UiChanges.Bake(USE_CASE_S1) }
                    .onErrorReturn { UiChanges.Error(USE_CASE_ERROR) }
                    .startWith(UiChanges.Processing(USE_CASE_PROCESSING))
            }
        val loadCheckChanged = actions.ofType(UiActions.Check::class.java)
            .switchMap {
                StartCheckCase().check()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<UiChanges> { UiChanges.Check(USE_CASE_S2) }
                    .onErrorReturn { UiChanges.Error(USE_CASE_ERROR) }
                    .startWith(UiChanges.Processing(USE_CASE_PROCESSING))
            }
        val loadEndChanged = actions.ofType(UiActions.End::class.java)
            .switchMap {
                StartEndCase().end()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<UiChanges> { UiChanges.End(USE_CASE_S3) }
                    .onErrorReturn { UiChanges.Error(USE_CASE_ERROR) }
                    .startWith(UiChanges.Processing(USE_CASE_PROCESSING))
            }

        val collection = Observable.merge(
            loadStartChanged,loadBakeChanged,loadCheckChanged,loadEndChanged)
        val dispose = collection.scan(initialState,reducer)
            .filter { !it.isIdle && !it.isError }
            .distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(state::postValue)
        disposables += dispose
    }

    /**
     * Fires after an associated event, determines the state as Entered.
     * @return state truth whether state is s0.
     */
    fun s0() {
        this.dispatch(UiActions.Start)
    }

    /**
     * Fires after an associated event, determines the state as Baked.
     * @return state truth whether state is s1.
     */
    fun s1() {
        this.dispatch(UiActions.Bake)
    }

    /**
     * Fires after an associated event, determines the state as Check.
     * @return state truth whether state is s2.
     */
    fun s2() {
        this.dispatch(UiActions.Check(baked = false))
    }

    /**
     * Fires after an associated event, determines the state as Bake or Ended.
     * @return state truth whether state is s3.
     */
    fun s3() {
        if((0..25).random() <= 11) {
            this.dispatch(UiActions.Bake)
        } else {
            this.dispatch(UiActions.End)
        }
    }
}

