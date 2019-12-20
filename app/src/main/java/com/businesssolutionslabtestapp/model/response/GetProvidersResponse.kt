package com.businesssolutionslabtestapp.model.response

import android.os.Parcelable
import com.businesssolutionslabtestapp.model.Provider
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetProvidersResponse(val providers: ArrayList<Provider>): Parcelable