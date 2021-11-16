package com.szareckii.movieschart.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    @Expose val adult: String? = null,
    @Expose val backdrop_path: String? = null,
    @Expose val id: String? = null,
    @Expose val original_language: String? = null,
    @Expose val original_title: String? = null,
    @Expose val overview: String? = null,
    @Expose val popularity: String? = null,
    @Expose val poster_path: String? = null,
    @Expose val release_date: String? = null,
    @Expose val title: String? = null,
    @Expose val video: String? = null,
    @Expose val vote_average: String? = null,
    @Expose val vote_count: String? = null,
): Parcelable
