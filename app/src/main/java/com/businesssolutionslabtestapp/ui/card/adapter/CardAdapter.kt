package com.businesssolutionslabtestapp.ui.card.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.model.GiftCard

class CardAdapter(var list: ArrayList<GiftCard>,
                  val colorType: Int,
                  private val onItemClickListener: (GiftCard) -> Unit): RecyclerView.Adapter<CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardHolder(view)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: CardHolder, position: Int) = holder.bind(list[position], onItemClickListener)

    fun updateData(list: ArrayList<GiftCard>) {

        for(i in list) {
            i.colorType = colorType
        }
        this.list = list
        notifyDataSetChanged()
    }
}