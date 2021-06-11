package com.dicoding.jetpack.themoviedb.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesResponse(
    var id: Int? = 0,
    var poster_path: String? = null,
    var title: String? = null,
    var release_date: String? = null,
    var vote_average: String? = null,
    var overview: String? = null
): Parcelable
