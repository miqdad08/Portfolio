package com.miqdad.portfolio.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portfolio(
    var id: Int = 0,
    var title: String = "",
    var detail: String= "",
    var link: String= "",
    var image: Int = 0
): Parcelable