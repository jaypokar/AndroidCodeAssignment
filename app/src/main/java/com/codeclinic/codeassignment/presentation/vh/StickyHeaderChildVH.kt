package com.codeclinic.codeassignment.presentation.vh

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.codeclinic.codeassignment.R
import com.codeclinic.codeassignment.data.model.Urls
import com.codeclinic.codeassignment.databinding.ItemStickyHeaderChildBinding
import com.codeclinic.codeassignment.util.inflate
import com.lopei.collageview.CollageView
import smartadapter.viewholder.SmartViewHolder

class StickyHeaderChildVH(parentView: ViewGroup) : SmartViewHolder<Urls>(
    parentView.inflate<ItemStickyHeaderChildBinding>(R.layout.item_sticky_header_child).root
) {


    override fun bind(item: Urls) {
        val binding = DataBindingUtil.getBinding<ItemStickyHeaderChildBinding>(itemView)
        if (binding != null) {
            val allUrls: ArrayList<String> = ArrayList()

            allUrls.add(item.regular.toString())
            allUrls.add(item.regular.toString())
            allUrls.add(item.regular.toString())
            allUrls.add(item.regular.toString())
            allUrls.add(item.regular.toString())

            binding.collageView.photoMargin(2)
                .photoPadding(3)
                .useFirstAsHeader(false)
                .useCards(true)
                .maxWidth(250)
                .placeHolder(R.drawable.loading_placeholder) //adds placeholder resource
                .headerForm(CollageView.ImageForm.IMAGE_FORM_HALF_HEIGHT) // sets form of image for header (if useFirstAsHeader == true)
                .photosForm(CollageView.ImageForm.IMAGE_FORM_SQUARE) //sets form of image for other photos
                .loadPhotos(allUrls)
        }


    }

}