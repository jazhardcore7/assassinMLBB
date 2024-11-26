package com.dicoding.assassinmlbb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Heroes (
    val name: String,
    val description: String,
    val photo: String,
    var role: String,
    var tahunRilis: Int,
    var urutHero: Int,
    var sejarahSingkat: String
) : Parcelable
