package coffee.flavors.androidtutorials.pizzamia.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutPizzamiaPizzaboxBinding
import coffee.flavors.androidtutorials.pizzamia.controller.ViewModelPizzaBox
import coffee.flavors.androidtutorials.pizzamia.controller.adapter.PizzaBoxAdapter
import coffee.flavors.androidtutorials.pizzamia.model.ModelChips
import coffee.flavors.androidtutorials.pizzamia.model.ModelPizza
import coffee.flavors.androidtutorials.pizzamia.tools.CoroutineWorkerIf
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ViewPizzaBox : AppCompatActivity(), CoroutineWorkerIf {
    private lateinit var mData: ModelPizza

    private val mVM: ViewModelPizzaBox by viewModel()

    private lateinit var mBinding: LayoutPizzamiaPizzaboxBinding

    override lateinit var mWorker: Job

    override var coroutineContext: CoroutineContext = newSingleThreadContext("ViewPizzaBox")

    private lateinit var mDisposable: io.reactivex.rxjava3.disposables.Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.fireUiBindings()
        this.generationUi()
        this.registerUi()
        this.subscribeUi()
        this.listenRx()
    }

    /* purposely prevent accessing the list of pre-defined data only accessible through rx o's */
    private val list: MutableList<String> = mutableListOf("pizzamia","pizzabbq","pizzaclassic","pizzamgr","pizzadog")
    private lateinit var mPizzanameObservable: Observable<MutableList<String>>
    private lateinit var mPizzanameObserver: io.reactivex.rxjava3.core.Observer<MutableList<String>>

    private fun listenRx(){
        val rxPizzanameObserver = this.rxPizzanameObserver()
        this.rxPizzaNameObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
    private fun rxPizzaNameObservable(): Observable<MutableList<String>> {
        this.mPizzanameObservable = Observable.just(list)
        return this.mPizzanameObservable
    }
    private fun rxPizzanameObserver(): io.reactivex.rxjava3.core.Observer<MutableList<String>> {
        return object : io.reactivex.rxjava3.core.Observer<MutableList<String>> {
            override fun onSubscribe(d: io.reactivex.rxjava3.disposables.Disposable?) {
                Log.i("onNext()", d.toString())
                if (d != null) {
                    this@ViewPizzaBox.mDisposable = d
                }
            }
            override fun onNext(t: MutableList<String>?) {
                Log.i("onNext()", t.toString())
            }
            override fun onError(e: Throwable) {
                Log.i("onError()", e.toString())
            }
            override fun onComplete() {
                Log.i("onComplete()", "done.")
            }
        }
    }

    private fun generationUi(){
        val pizzamia = Chip(this)
        val pizzabbq = Chip(this)
        val pizzaclassic = Chip(this)
        val pizzamgr = Chip(this)
        val pizzadog = Chip(this)

        pizzamia.setChipDrawable(ChipDrawable.createFromAttributes(this, null, 0, R.style.MtrlTheme_Chip))
        pizzabbq.setChipDrawable(ChipDrawable.createFromAttributes(this, null, 0, R.style.MtrlTheme_Chip))
        pizzaclassic.setChipDrawable(ChipDrawable.createFromAttributes(this, null, 0, R.style.MtrlTheme_Chip))
        pizzamgr.setChipDrawable(ChipDrawable.createFromAttributes(this, null, 0, R.style.MtrlTheme_Chip))
        pizzadog.setChipDrawable(ChipDrawable.createFromAttributes(this, null, 0, R.style.MtrlTheme_Chip))

        pizzamia.text = ModelChips().pizzamia().toString()
        pizzabbq.text = ModelChips().pizzabbq().toString()
        pizzaclassic.text = ModelChips().pizzaclassic().toString()
        pizzamgr.text = ModelChips().pizzamgr().toString()
        pizzadog.text = ModelChips().pizzadog().toString()

        pizzamia.setTextColor(resources.getColor(R.color.colorLightLight, null))
        pizzabbq.setTextColor(resources.getColor(R.color.colorLightLight, null))
        pizzaclassic.setTextColor(resources.getColor(R.color.colorLightLight, null))
        pizzamgr.setTextColor(resources.getColor(R.color.colorLightLight, null))
        pizzadog.setTextColor(resources.getColor(R.color.colorLightLight, null))

        this.mBinding.mtrlChipGp.addView(pizzamia)
        this.mBinding.mtrlChipGp.addView(pizzabbq)
        this.mBinding.mtrlChipGp.addView(pizzaclassic)
        this.mBinding.mtrlChipGp.addView(pizzamgr)
        this.mBinding.mtrlChipGp.addView(pizzadog)
    }

    private fun registerUi(){
        this.mBinding.rvDb.layoutManager = LinearLayoutManager(this)
        this.mBinding.rvDb.adapter = PizzaBoxAdapter(this@ViewPizzaBox, this.mVM.mModelPizza)
    }

    private fun subscribeUi(){
        this.mBinding.mtrlBtnDbShow.setOnClickListener {
            if(this.mBinding.rvDb.isVisible){
                this.mBinding.rvDb.visibility = View.GONE
            } else {
                this.mBinding.rvDb.visibility = View.VISIBLE
            }
        }

        this.mBinding.mtrlChipGp.setOnCheckedChangeListener { group, id ->
            val chip = this@ViewPizzaBox.findViewById<Chip>(id)
            if(chip != null){
                group.forEachIndexed { index, view ->
                    if(view.id != chip.id){
                        view.isEnabled = false
                    }
                }
                if(!this.mBinding.mtrlBtnDbAdd.isEnabled && !this.mBinding.mtrlBtnDbDel.isEnabled)
                this.mBinding.mtrlBtnDbAdd.isEnabled = true
                this.mBinding.mtrlBtnDbDel.isEnabled = true
            } else {
                group.forEachIndexed { index, view ->
                    view.isEnabled = true
                }
                if(this.mBinding.mtrlBtnDbAdd.isEnabled && this.mBinding.mtrlBtnDbDel.isEnabled)
                    this.mBinding.mtrlBtnDbAdd.isEnabled = false
                this.mBinding.mtrlBtnDbDel.isEnabled = false
            }
        }

        this.mVM.mPizzaLD.observe(this, Observer {
            it.let { l ->
                this@ViewPizzaBox.mVM.mModelPizza.clear()
                this.mBinding.rvDb.adapter?.notifyDataSetChanged()
                l.forEach { m ->
                    this@ViewPizzaBox.mVM.mModelPizza.add(m)
                }
                this.mBinding.rvDb.adapter?.notifyDataSetChanged()
            }
        })

        this.mBinding.mtrlBtnDbAdd.setOnClickListener {
            for(i in 0..this.mBinding.mtrlChipGp.childCount){
                val child = this.mBinding.mtrlChipGp.getChildAt(i)
                if(child != null && (child as Chip).isChecked){
                    this@ViewPizzaBox.supply( ModelChips().generate((child as Chip).text.toString()) )
                    Toast.makeText(this,"ADDED",Toast.LENGTH_SHORT).show()
                    break /* by design only one chip can be selected, so no need to iterate further */
                }
            }
        }

        this.mBinding.mtrlBtnDbDel.setOnClickListener {
            for(i in 0..this.mBinding.mtrlChipGp.childCount){
                val child = this.mBinding.mtrlChipGp.getChildAt(i)
                if(child != null && (child as Chip).isChecked){
                    this@ViewPizzaBox.expunge( ModelChips().generate((child as Chip).text.toString()) )
                    Toast.makeText(this,"DELETED",Toast.LENGTH_SHORT).show()
                    break /* by design only one chip can be selected, so no need to iterate further */
                }
            }
        }
    }

    /* ui will bind itself to layouts, for consistency */
    private fun fireUiBindings(){
        /* binding is generated through BR class, this will set the view through binding */
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_pizzamia_pizzabox)
        /* execute pending bindings */
        this.mBinding.executePendingBindings()
    }

    override fun onDestroy() {
        mWorker.cancel()
        mDisposable.dispose()
        super.onDestroy()
    }

    private fun supply(data: ModelPizza) {
        this.mWorker = launch {
            this@ViewPizzaBox.mVM.mPizzaDB.mDaoPizza().insert(data)
        }
        this.mBinding.rvDb.adapter?.notifyDataSetChanged()
    }

    private fun expunge(data: ModelPizza) {
        this.mWorker = launch {
            this@ViewPizzaBox.mVM.mPizzaDB.mDaoPizza().delete(data.pizzaname)
        }
        this.mBinding.rvDb.adapter?.notifyDataSetChanged()
    }
}