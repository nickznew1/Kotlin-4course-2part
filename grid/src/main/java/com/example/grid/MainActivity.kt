package com.example.grid

import android.annotation.SuppressLint
import android.app.Activity

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.grid.data.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )
        setContent {


            MyApplicationTheme {

              Surface(
                  modifier = Modifier
                      .fillMaxSize(),
                  color = Color(0xFF800080),

              ){
                  TopicGridApp()

                }
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
@Preview
private fun TopicCardPreview(){
    TopicCard(
        Topic(R.string.film, 55, R.drawable.film)
    )
}

@Composable
fun TopicGridApp(){
val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    )
    {
        TopicList(
            topicList = DataSource.loadTopics()
        )
    }
}

@Composable
fun TopicList(
    topicList: List<Topic>,
    modifier: Modifier = Modifier,
)
{
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        items(topicList) {topic ->
            TopicCard(
                topic = topic,
                /*modifier*/
            )
        }
    }

}
@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier,
    )
{
    Card(modifier = Modifier
        .height(68.dp)
        .fillMaxSize()) {
        Row(){
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .width(68.dp),
                contentScale = ContentScale.Crop,
            )
            Column(){
                Text(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp,
                        ),
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(topic.stringResourceId),
                )
                Row(modifier = Modifier
                    .fillMaxSize()){
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = stringResource(topic.stringResourceId),
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                            )
                    )
                    Text(
                        text = "${topic.count}",
                        modifier = Modifier
                            .padding(
                                start = 8.dp
                            )
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}



