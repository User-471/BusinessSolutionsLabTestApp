package com.businesssolutionslabtestapp.ui.card

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.businesssolutionslabtestapp.R
import com.businesssolutionslabtestapp.model.GiftCard
import com.businesssolutionslabtestapp.ui.base.BaseFragment
import com.businesssolutionslabtestapp.util.CARD
import com.businesssolutionslabtestapp.util.loadPicture
import com.businesssolutionslabtestapp.util.loadPictureWithoutCrop
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : BaseFragment() {

    private lateinit var card: GiftCard

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card = arguments!!.getParcelable(CARD)!!

        setData()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        iv_toolbar_back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setData() {
        tv_toolbar_title.text = card.title
        tv_card_description.text = card.description

        loadPictureWithoutCrop(iv_card_image_detail, card.image_url)
    }
}
