package com.businesssolutionslabtestapp.ui.providers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.model.GiftCard
import com.businesssolutionslabtestapp.model.Provider

class ProvidersAdapter(var list: ArrayList<Provider>,
                       private val onItemClickListener: (GiftCard) -> Unit): RecyclerView.Adapter<ProvidersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvidersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provider, parent, false)
        return ProvidersHolder(view)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ProvidersHolder, position: Int) = holder.bind(list[position], onItemClickListener)

    fun updateData(list: ArrayList<Provider>) {

        for(i in list.indices) {
            if (i % 2 == 0) {
                list[i].colorType = 0
            }
            else {
                list[i].colorType = 1
            }
        }

        this.list = list
        notifyDataSetChanged()
    }

    fun doubleCards() {
        for(i in list) {
            i.gift_cards.addAll(i.gift_cards)
        }

        notifyDataSetChanged()
    }
}