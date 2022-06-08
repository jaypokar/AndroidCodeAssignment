package com.codeclinic.codeassignment.presentation.vh

import android.view.ViewGroup
import android.widget.TextView
import com.codeclinic.codeassignment.R
import com.codeclinic.codeassignment.data.model.Section
import smartadapter.viewholder.SmartViewHolder

class StickyHeaderParentVH(parentView: ViewGroup) :
    SmartViewHolder<Section>(parentView, R.layout.item_sticky_header_parent) {
    private val headerView: TextView = itemView.findViewById(R.id.tvSectionHeader)
    override fun bind(item: Section) {
        headerView.text = item.section
    }
}