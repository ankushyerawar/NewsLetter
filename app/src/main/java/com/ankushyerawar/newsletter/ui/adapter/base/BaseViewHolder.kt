package com.ankushyerawar.newsletter.ui.adapter.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(parent: ViewGroup, layoutId: Int, clickListener: (pos: Int, aView: View) -> Unit) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)){

    init {
        itemView.setOnClickListener{
            clickListener.invoke(adapterPosition,itemView)
        }
    }
}