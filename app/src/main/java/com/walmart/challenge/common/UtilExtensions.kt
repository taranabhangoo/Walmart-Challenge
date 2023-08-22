package com.walmart.challenge.common

import android.content.Context
import android.util.TypedValue

fun Int.dpToPx(context: Context): Int {
    val displayMetrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics).toInt()
}