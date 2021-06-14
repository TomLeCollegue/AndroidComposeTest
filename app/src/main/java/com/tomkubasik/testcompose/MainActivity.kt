package com.tomkubasik.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomkubasik.testcompose.ui.EventCard
import com.tomkubasik.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}


@Composable
fun MyApp() {
    TestComposeTheme {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "Events",
                        fontSize = 24.sp
                    )
                },
                backgroundColor = Color.White
            )
            ListHighlightEvent()
            Text(
                text = "Afterwork",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ListEvent()
            Text(
                text = "Sport",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            ListEvent()
        }


    }
}

@Composable
fun ListHighlightEvent() {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(5) {
            EventHighlightCard()
        }
    }
}

@Composable
fun ListEvent() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(10) {
            EventCard()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}