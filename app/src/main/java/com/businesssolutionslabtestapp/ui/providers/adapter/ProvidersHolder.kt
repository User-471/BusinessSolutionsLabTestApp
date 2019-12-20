package com.businesssolutionslabtestapp.ui.providers.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.businesssolutionslabtestapp.model.GiftCard
import com.businesssolutionslabtestapp.model.Provider
import com.businesssolutionslabtestapp.ui.card.adapter.CardAdapter
import kotlinx.android.synthetic.main.item_provider.view.*

class ProvidersHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var adapter: CardAdapter

    fun bind(data: Provider, onItemClickListener: (GiftCard) -> Unit) {

        adapter = CardAdapter(arrayListOf(), data.colorType!!) { onItemClickListener(it) }

        itemView.rv_cards.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL ,false)
        itemView.rv_cards.adapter = adapter

        adapter.updateData(data.gift_cards)

        itemView.tv_provider_title.text = data.title
    }
}