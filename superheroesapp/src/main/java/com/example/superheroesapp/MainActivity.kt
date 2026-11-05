package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.HeroesRepository
import com.example.superheroesapp.data.HeroesRepository.heroes
import com.example.superheroesapp.model.Heroes
import com.example.superheroesapp.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperheroApp()
                }
                }
            }
        }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroAppTopBar(
    modifier: Modifier = Modifier,
    )
{
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Superheroes",
                    style = MaterialTheme.typography.displayLarge
                )

            }
        },
        modifier = modifier
    )
}

@Composable
fun SuperheroApp(){
    Scaffold(
        topBar = {
            SuperheroAppTopBar()
        }
    ) { it ->
        LazyColumn(
            contentPadding = it
        ) {
            items(heroes) { hero ->
                SuperHeroCard(hero = hero)
            }
        }
    }

}

@Preview
@Composable
fun SuperHeroDarkThemePreview(){
    SuperheroesTheme(darkTheme = true) {
        SuperheroApp()
    }
}

@Preview
@Composable
fun SuperHeroPreview(){
    SuperheroesTheme(darkTheme = false) {
        SuperheroApp()
    }
}




@Composable
fun SuperHeroCard(
    hero : Heroes,
    modifier: Modifier = Modifier,
)
{
    Card(modifier = modifier
        .clip(MaterialTheme.shapes.medium)
        .fillMaxSize()
        .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
        SuperheroCardContent(hero)
    }

}

@Composable
fun SuperheroCardContent(
    hero : Heroes,
    modifier : Modifier = Modifier,
){
    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            SuperheroText(
                hero.nameHero,
                hero.descHero,
            )
        }
        Spacer(modifier = Modifier
            .width(16.dp))

        SuperHeroImage(
            hero.picHero,
            hero.nameHero,
        )
    }
}

@Composable
fun SuperheroText(
    heroName: Int,
    heroDesc: Int,
    modifier: Modifier = Modifier,
){
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(heroDesc),
            style = MaterialTheme.typography.bodyLarge
        )

}

@Composable
fun SuperHeroImage(
    heroPic: Int,
    picDesc: Int,
) {
    Image(
        painter = painterResource(heroPic),
        contentDescription = stringResource(picDesc),
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .size(dimensionResource(R.dimen.image_size)),

        contentScale = ContentScale.Crop,
    )
}