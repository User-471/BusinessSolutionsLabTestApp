package com.businesssolutionslabtestapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Provider(val id: Int,
                    val title: String,
                    val image_url: String,
                    var gift_cards: ArrayList<GiftCard>,
                    var colorType: Int?): Parcelable