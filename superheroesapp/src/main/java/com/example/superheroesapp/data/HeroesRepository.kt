package com.example.superheroesapp.data

import com.example.superheroesapp.R
import com.example.superheroesapp.model.Heroes

object HeroesRepository {
    val heroes = listOf<Heroes>(
        Heroes(
            nameHero = R.string.hero1,
            descHero = R.string.description1,
            picHero = R.drawable.android_superhero1,
        ),
        Heroes(
            nameHero = R.string.hero2,
            descHero = R.string.description2,
            picHero = R.drawable.android_superhero2,
        ),
        Heroes(
            nameHero = R.string.hero3,
            descHero = R.string.description3,
            picHero = R.drawable.android_superhero3,
        ),
        Heroes(
            nameHero = R.string.hero4,
            descHero = R.string.description4,
            picHero = R.drawable.android_superhero4,
        ),
        Heroes(
            nameHero = R.string.hero5,
            descHero = R.string.description5,
            picHero = R.drawable.android_superhero5,
        ),
    )

    fun loadHeroes(): List<Heroes> {
        return heroes
    }
}