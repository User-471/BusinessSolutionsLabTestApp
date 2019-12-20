package com.businesssolutionslabtestapp.ui.card.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.model.GiftCard
import com.businesssolutionslabtestapp.util.loadPicture
import kotlinx.android.synthetic.main.item_card.view.*

class CardHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(data: GiftCard, onItemClickListener: (GiftCard) -> Unit) {

        itemView.setOnClickListener { onItemClickListener(data) }

        itemView.tv_card_price.text = when(data.title.substring(0, 6).contains(".")) {
            true -> {
                data.title.replaceAfter(" ", "").replace(" ", "")
            }
            false -> {
                "${data.title.replaceAfter(" ", "")}.00".replace(" ", "")
            }
        }
        itemView.tv_coins_amount.text = itemView.context.getString(R.string.comma_separated, data.credits)

        if(data.colorType == 0) {
            itemView.cl_coins.background = itemView.context.getDrawable(R.drawable.rounded_4_bottom_grey)
        }
        else {
            itemView.cl_coins.background = itemView.context.getDrawable(R.drawable.rounded_4_bottom_yellow)
        }


        loadPicture(itemView.iv_card_image, data.image_url)

        Log.d("TAG_TYPE", data.colorType.toString())

    }
}