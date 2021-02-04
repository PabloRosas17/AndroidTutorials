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

package coffee.flavors.androidtutorials.oww.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwDarkOkayBinding
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwDarkOkayBindingImpl
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightOkayBinding
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightOkayBindingImpl
import coffee.flavors.androidtutorials.oww.controller.ViewModelOww
import coffee.flavors.androidtutorials.oww.controller.adapter.CardViewFeedAdapter
import coffee.flavors.androidtutorials.oww.core.ApplicationOww
import coffee.flavors.androidtutorials.oww.model.ModelEntity
import coffee.flavors.androidtutorials.oww.services.api.ServiceWeightWatchers
import coffee.flavors.androidtutorials.oww.tools.*
import coffee.flavors.androidtutorials.oww.tools.constants.*
import coffee.flavors.androidtutorials.oww.views.presenters.PresenterViewOww
import java.lang.RuntimeException
import javax.inject.Inject


/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, Ui screen.
 */

/* @purpose Ui screen that renders a recycler view displaying service api response, contains state for themes and network response. */
class ViewOww @Inject constructor(): AppCompatActivity(), ViewBinderIf<ViewDataBinding>, ThemeCallbackIf {

    /**
     * Adds a service to perform api calls to weight watchers api.
     * @return [ServiceWeightWatchers]
     */
    @Inject lateinit var serviceWeightWatchers: ServiceWeightWatchers

    /**
     * Adds a [mBinding] to this.
     * @return promised binding.
     */
    override lateinit var mBinding: ViewDataBinding

    /**
     * Injection for view model by koin and dependency injection by constructor
     * @return ViewModelOww
     */
    lateinit var mVmOww : ViewModelOww

    /**
     * Local that holds the position of the adapter.
     * @return the position.
     */
    private var mRvPosition: Int = AdapterConstants.NULL_ITEMS

    /**
     * Local that holds the default theme which can change.
     * @return the theme.
     */
    private var mTheme: String = StringGlobals.LIGHT_MODE

    /**
     * Determines if there's a state.
     * If a state isn't available then do bindings and ui initialization.
     * If a state is available then un-marshal keys to get theme.
     * Then provide ui initialization (and a dummy coroutine, to abide by [CoroutineWorkerIf])
     * @param savedInstanceState as state.
     */
    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        (application as ApplicationOww).mComponent.inject(this)
        this.mVmOww = ViewModelProvider(this).get(ViewModelOww::class.java)
        if(state == null){
            this.fireUiBindings()
            mVmOww.fire(this, serviceWeightWatchers)
            this.registerUi()
            this.listenersUi()
        } else {
            if (state.get(MarshallizedTokens.KEY_SM_THEME_MODE) != null) {
                this.mTheme = state.get(MarshallizedTokens.KEY_SM_THEME_MODE) as String
            }
            this.fireUiBindings()
            mVmOww.fire(this, serviceWeightWatchers)
            this.registerUi()
            this.listenersUi()
        }
    }

    /**
     * Registers a default card view adapter, otherwise very nasty log messages happen.
     * It's a good practice to handle this especially when implementing themes.
     * @param savedInstanceState as state.
     * @throws RuntimeException when the binding is unknown.
     */
    private fun uniqueUi(binding: ViewDataBinding) {
        when(binding) {
            is LayoutViewOwwDarkOkayBinding -> {
                binding.owwRv.layoutManager = LinearLayoutManager(this@ViewOww, LinearLayoutManager.HORIZONTAL, false)
                binding.owwRv.adapter = CardViewFeedAdapter(this@ViewOww, mVmOww)
            }
            is LayoutViewOwwLightOkayBinding -> {
                binding.owwRv.layoutManager = LinearLayoutManager(this@ViewOww, LinearLayoutManager.HORIZONTAL, false)
                binding.owwRv.adapter = CardViewFeedAdapter(this@ViewOww, mVmOww)
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :$mTheme for uniqueUi() mBinding.")}
        }
    }

    /* ui will bind itself to layouts, for consistency */
    /* binding is generated through BR class, this will set the view through binding */
    /* bind presenter account instance with this view */
    /* execute pending bindings */
    override fun fireUiBindings(){
        when(this.mTheme) {
            StringGlobals.DARK_MODE -> {
                this.setTheme(R.style.OwwAppDarkMaterialTheme)
                this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_oww_dark_okay)
                (this.mBinding as LayoutViewOwwDarkOkayBinding).mPresenter = PresenterViewOww(this@ViewOww)
                this.uniqueUi(mBinding)
            }
            StringGlobals.LIGHT_MODE -> {
                this.setTheme(R.style.OwwAppLightMaterialTheme)
                this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_oww_light_okay)
                (this.mBinding as LayoutViewOwwLightOkayBinding).mPresenter = PresenterViewOww(this@ViewOww)
                this.uniqueUi(mBinding)
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :$mTheme for fireUiBindings() mBinding.")}
        }
        this.mBinding.executePendingBindings()
    }

    /**
     * Determines the theme mode and proceeds to initialize adapter.
     * @throws RuntimeException when the the binding is unknown.
     */
    override fun subscribeUi() {
        when(this.mTheme) {
            StringGlobals.DARK_MODE -> {
                val darkcast = (this.mBinding as LayoutViewOwwDarkOkayBinding)
                darkcast.owwRv.layoutManager = LinearLayoutManager(this@ViewOww, LinearLayoutManager.HORIZONTAL, false)
                darkcast.owwRv.adapter = CardViewFeedAdapter(this@ViewOww, mVmOww)
            }
            StringGlobals.LIGHT_MODE -> {
                val lightcast = (this.mBinding as LayoutViewOwwLightOkayBinding)
                lightcast.owwRv.layoutManager = LinearLayoutManager(this@ViewOww, LinearLayoutManager.HORIZONTAL, false)
                lightcast.owwRv.adapter = CardViewFeedAdapter(this@ViewOww, mVmOww)
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :$mTheme for subscribeUi() mBinding.")}
        }
    }

    /**
     * Find the element and register listener with the ui.
     */
    override fun registerUi(){}

    /**
     * Listener that resembles the LOD principle, encapsulates observers observables.
     */
    override fun listenersUi(){

        this.mVmOww.mList.observe(this, Observer<List<ModelEntity>> {
            /* this.mVmOww.mModelOww.list = it as MutableList<ModelEntity> */
        })

        /* logic for handling different states after network response resolves */
        this.mVmOww.mViewState.observe(this, Observer<ViewState> {
            when(it) {
                ViewState.LOAD_ERROR -> {
                    this@ViewOww.finish()
                    OwwUtil().fireIntent(this,ViewError::class.java)
                }
                ViewState.LOAD_EMPTY -> {
                    this@ViewOww.finish()
                    OwwUtil().fireIntent(this,ViewEmpty::class.java)
                }
                ViewState.LOAD_OKAY -> {
                    /* okay status, proceed with loading this view */
                }
                else -> { throw RuntimeException("ViewOww.kt, unknown :$it state for listenersUi().")}
            }
        })
    }

    /**
     * Handle state changes for E as events, like rotation and like themes.
     * This method will determine the marshalized values and resolve based on their properties.
     * Theme is implemented by logic but this could have been done through reified (reflection) strategy.
     * Essentially this method will fire a "dynamic-polymorphic" binding.
     * @param state as the bundle instance.
     */
    override fun onSaveInstanceState(state: Bundle) {
        super.onSaveInstanceState(state)

        if(state.get(MarshallizedTokens.KEY_SM_THEME_MODE) != null) {
            this.mTheme = state.get(MarshallizedTokens.KEY_SM_THEME_MODE) as String
        }

        when(this.mTheme) {
            StringGlobals.DARK_MODE -> {
                when(this.mBinding) {
                    is LayoutViewOwwDarkOkayBindingImpl -> { this.persistentUi(mBinding) }
                    is LayoutViewOwwLightOkayBindingImpl -> { this.persistentUi(mBinding) }
                    else -> { throw RuntimeException("ViewOww.kt, unknown type :$mBinding for onSaveInstanceState() mBinding.")}
                }
            }
            StringGlobals.LIGHT_MODE -> {
                when(this.mBinding) {
                    is LayoutViewOwwLightOkayBindingImpl -> { this.persistentUi(mBinding) }
                    is LayoutViewOwwDarkOkayBindingImpl -> { this.persistentUi(mBinding) }
                    else -> { throw RuntimeException("ViewOww.kt, unknown type :$mBinding for onSaveInstanceState() mBinding.")}
                }
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :$mTheme for onSaveInstanceState() mTheme.")}
        }
        state.putString(MarshallizedTokens.KEY_SM_THEME_MODE, this.mTheme)
        state.putInt(MarshallizedTokens.KEY_RV_POSITION_ON_ORIENTATION_CHANGE, this.mRvPosition)
    }

    /**
     * Handles adapter persistency.
     * @param binding as the "dynamic-polymorphic" binding.
     */
    private fun persistentUi(binding: ViewDataBinding){
        when(binding) {
            is LayoutViewOwwLightOkayBinding -> {
                this.fireUiBindings()
                if(binding.owwRv.adapter != null) {
                    this.mRvPosition = (binding.owwRv.adapter as CardViewFeedAdapter).invokeAdapterPosition()
                }
            }
            is LayoutViewOwwDarkOkayBinding -> {
                this.fireUiBindings()
                if(binding.owwRv.adapter != null) {
                    this.mRvPosition = (binding.owwRv.adapter as CardViewFeedAdapter).invokeAdapterPosition()
                }
            }
        }
    }

    /**
     * Handles adapter persistency (scroll to position).
     * @param state as the state.
     * @throws RuntimeException when the binding is unknown.
     */
    override fun onRestoreInstanceState(state: Bundle) {
        super.onRestoreInstanceState(state)

        this.mRvPosition = state.getInt(MarshallizedTokens.KEY_RV_POSITION_ON_ORIENTATION_CHANGE)
        when(this.mBinding) {
            is LayoutViewOwwDarkOkayBinding -> {
                val darkcast = (this.mBinding as LayoutViewOwwDarkOkayBinding)
                darkcast.owwRv.post{ darkcast.owwRv.scrollToPosition(this.mRvPosition) }
            }
            is LayoutViewOwwLightOkayBinding -> {
                val lightcast = (this.mBinding as LayoutViewOwwLightOkayBinding)
                lightcast.owwRv.post{ lightcast.owwRv.scrollToPosition(this.mRvPosition) }
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :$mTheme for onRestoreInstanceState() mBinding.")}
        }
    }

    /**
     * Delegate that performs state changes to generate a new theme during runtime.
     * @param mode as the theme mode.
     */
    override fun call(mode: Boolean) {
        when(mode){
            true -> {
                val temp = Bundle()
                temp.putString(MarshallizedTokens.KEY_SM_THEME_MODE, StringGlobals.DARK_MODE)
                this.onSaveInstanceState(temp)
            }
            false -> {
                val temp = Bundle()
                temp.putString(MarshallizedTokens.KEY_SM_THEME_MODE, StringGlobals.LIGHT_MODE)
                this.onSaveInstanceState(temp)
            }
        }
    }
}