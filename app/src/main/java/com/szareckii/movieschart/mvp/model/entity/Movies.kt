package com.szareckii.movieschart.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @Expose val page: String? = null,
    @Expose val results: List<Results>,
    @Expose val total_pages: String? = null,
    @Expose val total_results: String? = null
): Parcelable