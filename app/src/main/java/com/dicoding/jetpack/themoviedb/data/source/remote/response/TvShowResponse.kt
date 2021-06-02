package com.dicoding.jetpack.themoviedb.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    var id: Int = 0,
    var poster_path: String? = null,
    var name: String? = null,
    var first_air_date: String? = null,
    var vote_average: String? = null,
    var overview: String? = null
)
