package com.dicoding.jetpack.themoviedb.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_tv_show")
@Parcelize
data class TvShowEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "tvShow_id")
    var tvShow_id: Int = 0,

    @NonNull
    @ColumnInfo(name = "poster")
    var poster_path: String? = null,

    @NonNull
    @ColumnInfo(name = "name")
    var name: String? = null,

    @NonNull
    @ColumnInfo(name = "release")
    var first_air_date: String? = null,

    @NonNull
    @ColumnInfo(name = "rating")
    var vote_average: String? = null,

    @NonNull
    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable