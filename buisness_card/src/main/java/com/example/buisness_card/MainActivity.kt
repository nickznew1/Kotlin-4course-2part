package com.example.buisness_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisness_card.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeCardApp()
                }
            }
        }
    }
}
@Composable
fun ComposeCardApp(){


        Box(
            contentAlignment = Alignment.Center
            ) {
            BusinessCardTitle(
                stringResource(R.string.business_card_name),
                stringResource(R.string.business_card_title),
            )
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(50.dp)
        ) {
            BusinessCardMisc(
                stringResource(R.string.business_card_number),
                stringResource(R.string.business_card_link),
                stringResource(R.string.business_card_email)
            )
        }

}

@Composable
private fun BusinessCardTitle (
    name: String,
    title: String,
    modifier: Modifier = Modifier,
     )
{
    val image = painterResource(R.drawable.baseline_email_24)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
        ) {
            Row(){
            Image(
                painter = image,
                contentDescription = null
            )
            }
            Row() {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                )
            }
            Row() {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    )
            }
        }

}

@Composable
private fun BusinessCardMisc(
    phoneNumber: String,
    link: String,
    email: String,
    modifier: Modifier = Modifier,
    ) {
        Column(modifier){
            Row(modifier = modifier
                .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Icon(painter = painterResource(
                    R.drawable.baseline_local_phone_24),
                    contentDescription = null,
                    )
                Text (
                    text = phoneNumber,
                    fontSize = 20.sp,
                )
            }
           Row(modifier = modifier
               .padding(10.dp),
               horizontalArrangement = Arrangement.spacedBy(12.dp)
           ) {
                Icon(painter = painterResource(
                    R.drawable.baseline_arrow_circle_right_24),
                    contentDescription = null,
                )
                Text (
                    text = link,
                    fontSize = 20.sp,


                )
            }
            Row(modifier = modifier
                .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                Icon(painter = painterResource(
                    R.drawable.baseline_email_24),
                    contentDescription = null,
                )
                Text (
                    text = email,
                    fontSize = 20.sp,
                )
            }
        }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme {
       ComposeCardApp()
    }
}