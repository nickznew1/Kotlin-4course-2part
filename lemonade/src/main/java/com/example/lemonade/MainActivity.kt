package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
               LemonadeApp()
            }
        }
    }
}

@Composable
@Preview
fun LemonadeApp (
    modifier : Modifier = Modifier,
    )
{
    LemonadeButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
    )

}

@Composable
fun LemonadeButtonAndImage(
    modifier: Modifier = Modifier,
     )
{
    var text = ""
    var image = R.drawable.lemon_tree
    var imageAnnotation = ""
    var stage by remember { mutableStateOf(1) }
    var resultClicks by remember { mutableStateOf(0) }

    var clicks = (2..4).random()
    val changeStage = when(stage){
        1 -> {
            text = stringResource(R.string.lemon_choose)
            image = R.drawable.lemon_tree
            imageAnnotation = stringResource(R.string.lemon_tree)
        }
        2 -> {
            text = stringResource(R.string.lemon_squeeze)
            image = R.drawable.lemon_squeeze
            imageAnnotation = stringResource(R.string.lemon)
        }
        3 -> {
            text = stringResource(R.string.lemon_drink)
            image = R.drawable.lemon_drink
            imageAnnotation = stringResource(R.string.lemonade_glass)
        }
        else ->{
            text = stringResource(R.string.lemon_empty)
            image = R.drawable.lemon_restart
            imageAnnotation = stringResource(R.string.glass_empty)
        }
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {

            if (stage ==2){
               resultClicks++
                if (resultClicks >= clicks){
                    stage++
                    resultClicks=0
                    clicks = (2..4).random()
                }
            } else {
                stage++
                if (stage > 4) {
                    stage = 1
                }
                resultClicks = 0
            }

        }) {
        Image(
            painter = painterResource(image),
            contentDescription = imageAnnotation
        )

    }
        Spacer(
            modifier = Modifier.height(16.dp),
        )

        Text(
            text = text
        )
    }

}
