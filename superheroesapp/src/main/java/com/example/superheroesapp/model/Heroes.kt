package com.example.superheroesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Heroes (
    @StringRes val nameHero: Int,

    @StringRes val descHero: Int,

    @DrawableRes val picHero: Int,
)

