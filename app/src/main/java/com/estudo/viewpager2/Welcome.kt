package com.estudo.viewpager2

import androidx.annotation.DrawableRes

data class Welcome(
    val title: String,
    @DrawableRes val drawableResId: Int,
    val description: String
)