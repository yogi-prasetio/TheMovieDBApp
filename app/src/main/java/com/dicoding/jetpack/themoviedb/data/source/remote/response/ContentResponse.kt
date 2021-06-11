package com.dicoding.jetpack.themoviedb.data.source.remote.response

data class ContentResponse <T> (

    var results: List<T>,
    var page: Int
)
