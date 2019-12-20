package com.businesssolutionslabtestapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GiftCard(val id: Int,
                    val featured: Boolean,
                    val title: String,
                    val credits: Int,
                    val image_url: String,
                    val codes_count: Int,
                    val currency: String,
                    val description: String,
                    val redeem_url: String,
                    var colorType: Int?
                    ): Parcelable