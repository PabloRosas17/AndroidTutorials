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

package coffee.flavors.androidtutorials.oww.controller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.ViewCardItemOwwLightLayoutBinding
import coffee.flavors.androidtutorials.oww.controller.ViewModelOww
import coffee.flavors.androidtutorials.oww.tools.constants.NetworkConstants
import coffee.flavors.androidtutorials.oww.views.ViewOww
import coffee.flavors.androidtutorials.oww.views.presenters.PresenterCardItem
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @param V as [viewOww] view.
 * @param VM as [mVmOww] view-model.
 * @purpose, adapter representing the model and view for the card items attached to a recycler view.
 */

class CardViewFeedAdapter(private val viewOww: ViewOww, private val mVmOww: ViewModelOww) : RecyclerView.Adapter<CardViewFeedAdapter.CardItemHolder>() {

    /**
     * instance of the card holder, needed to obtain adapter position.
     * @return c as [mCardItemHolder].
     */
    private var mCardItemHolder: CardItemHolder? = null

    /**
     * view holder used to inflate the card when needed.
     * @return c as [CardItemHolder].
     */
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CardItemHolder {
        val mCardInflater = LayoutInflater.from(parent.context)
        val mView = mCardInflater.inflate(R.layout.view_card_item_oww_light_layout, parent, false)
        return CardItemHolder(mView)
    }

    /**
     * binds data to ui element in each row, by design children will inherit and specify details here.
     */
    override fun onBindViewHolder(holder: CardItemHolder, position: Int) {
        holder.bind(position)

        /* get the model for the card view */
        this.mCardItemHolder = holder
        val title =  mVmOww.mModelOww.list[position].title
        val image = mVmOww.mModelOww.list[position].image
        val filter = mVmOww.mModelOww.list[position].filter

        /* get the views represented on the card item */
        val img = holder.itemView.findViewById<ImageView>(R.id.mtrl_card_img)
        var tv = holder.itemView.findViewById<MaterialTextView>(R.id.mtrl_card_title)

        /* logic determines is an image from the response is blank */
        if(image.isEmpty() || image.isBlank()){
            img.setImageDrawable(viewOww.resources.getDrawable(R.drawable.error, null))
        } else {
            Picasso.with(viewOww).load(NetworkConstants.BASE_URL_WEIGHT_WATCHERS + image).fit().into(img)
        }

        /* update the view text with the text from the model */
        tv.text = "$title"
    }

    /**
     * total number of card items based on the data set, by design children will inherit and specify count.
     * @return i as [Int].
     */
    override fun getItemCount(): Int {
        return mVmOww.mModelOww.list.size
    }

    /**
     * determines the known position of the adapter.
     * @return i as [Int].
     */
    fun invokeAdapterPosition(): Int {
        if(this.mCardItemHolder != null){
            return this.mCardItemHolder!!.adapterPosition
        }
        return 0
    }

    /**
     * dynamically binds each card item and attaches their respective presenter.
     */
    inner class CardItemHolder(private val mItemView: View): RecyclerView.ViewHolder(mItemView) {
        fun bind(position: Int) {
            val mBinding = DataBindingUtil.bind<ViewCardItemOwwLightLayoutBinding>(mItemView)
            mBinding?.mPresenter = PresenterCardItem(mItemView, position)
            mBinding?.executePendingBindings()
        }
    }
}