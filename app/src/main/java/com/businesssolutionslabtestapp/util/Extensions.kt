package com.businesssolutionslabtestapp.util

import androidx.annotation.ColorInt
import com.google.android.material.snackbar.Snackbar

fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar {
    this.view.setBackgroundColor(colorInt)
    return this
}