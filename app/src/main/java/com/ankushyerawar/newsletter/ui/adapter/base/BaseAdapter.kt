package com.ankushyerawar.newsletter.ui.adapter.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val itemLayoutId: Int, private val itemsList: List<T>) :
    RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun bindData(holder: BaseViewHolder<T>, item: T)
    abstract fun clickListener(pos: Int, item: T, aView: View)

    override fun getItemCount(): Int = itemsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(
            parent,
            itemLayoutId
        ) { pos, aView ->
            clickListener(pos, itemsList[pos], aView)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        bindData(holder, itemsList[position])
    }
}

