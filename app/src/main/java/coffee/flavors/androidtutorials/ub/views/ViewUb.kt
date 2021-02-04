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

package coffee.flavors.androidtutorials.ub.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewUbBinding
import coffee.flavors.androidtutorials.ub.controller.ViewModelUb
import coffee.flavors.androidtutorials.ub.model.states.UiStates
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_ERROR_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_IDLE_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_PROCESSING_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_S0_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_S1_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_S2_NOTIFICATION
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.STATE_S3_NOTIFICATION
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * @author, evolandlupiz
 * @date, 3/5/2020
 * @property, AndroidTutorials
 * @purpose, TODO: purpose of ViewUb()...
 */

/* @purpose Ui screen that renders the view elements based on state. */
class ViewUb : AppCompatActivity() {

    /**
     * initial state, idle.
     * @return [state] as UiStates
     * @see ViewModelUb, will resolve on null after class initialization.
     */
    private val state : UiStates = UiStates(isIdle = true)

    /**
     *  Generate a view model by injection, state matters here.
     *  @return lazy ViewModelUb
     */
    private val mVmOww : ViewModelUb by viewModel { parametersOf(state) }

    /**
     * Adds a [mBinding] to this.
     * @return promised binding.
     */
    private lateinit var mBinding: LayoutViewUbBinding

    /**
     * Perform data binding and observations.
     * @param state as state.
     */
    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        this.fireUiBindings()
        this.listenersUi()
    }

    /* ui will bind itself to layouts, for consistency
     * binding is generated through BR class, this will set the view through binding
     * bind presenter account instance with this view
     * execute pending bindings */
    private fun fireUiBindings() {
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_ub)
        this.mBinding.executePendingBindings()
    }

    /* observe for changes to those with observables on them , set btn listeners */
    private fun listenersUi() {
        this.mVmOww.observableState.observe(this, Observer { state ->
            state?.let { renderUi(state) }
        })
        this.mBinding.mtrlBtnStartStateBakeCake.setOnClickListener {
            mVmOww.s1()
        }
        this.mBinding.mtrlBtnAddStateBakeCake.setOnClickListener {
            mVmOww.s2()
        }
        this.mBinding.mtrlBtnCheckStateBakeCake.setOnClickListener {
            mVmOww.s3()
        }
        this.mBinding.mtrlBtnEndStateBakeCake.setOnClickListener {
            mVmOww.s0()
        }
    }

    /* Renderers will act upon state to update the Ui. */
    private fun renderUi(state: UiStates){
        with(state) {
            when {
                this.s0Start -> renderStartUi()
                this.s1Bake -> renderBakeUi()
                this.s2Check -> renderCheckUi()
                this.s3End -> renderEndUi()
                this.isIdle -> renderIdleUi()
                this.isProcessing -> renderProcessingUi()
                this.isError -> renderErrorUi()
            }
        }
    }

    /* Render start state. */
    private fun renderStartUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_S0_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_s0)
        this.mBinding.mtrlBtnEndStateBakeCake.isEnabled = false
        this.mBinding.mtrlBtnStartStateBakeCake.isEnabled = true
    }

    /* Render bake state. */
    private fun renderBakeUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_S1_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_s1)
        this.mBinding.mtrlBtnStartStateBakeCake.isEnabled = false
        this.mBinding.mtrlBtnCheckStateBakeCake.isEnabled = false
        this.mBinding.mtrlBtnAddStateBakeCake.isEnabled = true
    }

    /* Render check state. */
    private fun renderCheckUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_S2_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_s2)
        this.mBinding.mtrlBtnAddStateBakeCake.isEnabled = false
        this.mBinding.mtrlBtnCheckStateBakeCake.isEnabled = true
    }

    /* Render end state. */
    private fun renderEndUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_S3_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_s3)
        this.mBinding.mtrlBtnCheckStateBakeCake.isEnabled = false
        this.mBinding.mtrlBtnEndStateBakeCake.isEnabled = true
    }

    /* Render idle state. */
    private fun renderIdleUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_IDLE_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_idle)
    }

    /* Render processing state.*/
    private fun renderProcessingUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_PROCESSING_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_processing)
    }

    /* Render error state. */
    private fun renderErrorUi(){
        Snackbar.make(this.findViewById(R.id.layout_view_ub_root),STATE_ERROR_NOTIFICATION, Snackbar.LENGTH_SHORT).show()
        this.mBinding.mtrlTVCurrentState.text = getString(R.string.tv_text_error)
    }
}