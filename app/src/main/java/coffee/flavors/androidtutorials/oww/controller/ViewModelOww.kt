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

package coffee.flavors.androidtutorials.oww.controller

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coffee.flavors.androidtutorials.oww.model.ModelEntity
import coffee.flavors.androidtutorials.oww.model.ModelOww
import coffee.flavors.androidtutorials.oww.services.api.ServiceWeightWatchers
import coffee.flavors.androidtutorials.oww.tools.OwwApiFilter
import coffee.flavors.androidtutorials.oww.tools.constants.NetworkConstants
import coffee.flavors.androidtutorials.oww.views.ViewOww
import coffee.flavors.androidtutorials.oww.views.ViewState
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, view model will contain logic, states, data, models, services, handlers, and almost anything non-ui.
 */
class ViewModelOww @Inject constructor() : ViewModel(){

    /**
     * An observer representing a state.
     * @return state as [mViewState].
     */
    val mViewState = MutableLiveData<ViewState>()

    /**
     * A mutable list containing entities of type ModelEntity.
     * @return model as [mModelOww].
     */
    val mModelOww: ModelOww = ModelOww()

    /**
     * An observer representing a mutable list of model entities.
     * @return list as [mList].
     */
    val mList = MutableLiveData<MutableList<ModelEntity>>()

    /**
     * Performs a network call on a coroutine off of uithread.
     * Generates the response and evaluates based on the context.
     * @throws RuntimeException when the network request isn't defined to existing states.
     */
    fun fire(
        view: ViewOww,
        serviceWeightWatchers: ServiceWeightWatchers
    ){
        viewModelScope.launch {
            val call = serviceWeightWatchers.getEntityRQ()
            call.enqueue(object : Callback<List<ModelEntity>> {
                override fun onFailure(call: Call<List<ModelEntity>>, t: Throwable) {
                    println(t.message)
                }
                override fun onResponse(call: Call<List<ModelEntity>>, response: Response<List<ModelEntity>>) {
                    println("response.code ${response.code()}")
                    println("response.message ${response.message()}")
                    println("response.body ${response.body()}")
                    when(response.code()){
                        NetworkConstants.OK -> {
                            mViewState.value = ViewState.LOAD_OKAY
                            OwwApiFilter().filter(response.body(), view.mVmOww.mModelOww)
                            view.subscribeUi()
                        }
                        NetworkConstants.BAD_REQUEST -> { mViewState.value = ViewState.LOAD_ERROR }
                        NetworkConstants.NOT_FOUND -> { mViewState.value = ViewState.LOAD_EMPTY }
                        else -> { throw RuntimeException("ViewOww.kt, unsupported :${response.code()} network status code") }
                    }
                }
            })
        }
    }
}