package com.ankushyerawar.newsletter.ui.adapter.main

import android.view.View
import com.ankushyerawar.newsletter.data.model.Article
import com.ankushyerawar.newsletter.ui.adapter.base.BaseAdapter
import com.ankushyerawar.newsletter.ui.adapter.base.BaseViewHolder

class HeadlinesAdapter(itemLayoutId: Int, itemsList: List<Article>) :
    BaseAdapter<Article>(itemLayoutId, itemsList) {

    override fun bindData(holder: BaseViewHolder<Article>, item: Article) {
        TODO("Not yet implemented")

    }

    override fun clickListener(pos: Int, item: Article, aView: View) {
        TODO("Not yet implemented")
    }
}