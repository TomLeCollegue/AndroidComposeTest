package com.tomkubasik.testcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomkubasik.testcompose.ui.theme.BlueChambery
import com.tomkubasik.testcompose.ui.theme.OrangeAfterWork
import com.tomkubasik.testcompose.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun EventHighlightCard() {
    Column(
        Modifier
            .width(290.dp)
            .clip(RoundedCornerShape(13.dp))) {
        Image(
            painter = painterResource(R.drawable.beer),
            contentDescription = "beer",
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .alpha(0.9f),
            contentScale = ContentScale.FillWidth
        )
        Column(Modifier.padding(8.dp)) {
            CardEventTags()
            CardEventTitle(text = "Afterwork dans la pampa, venez on va boire un coup")
            Divider(Modifier.height(4.dp), color = Color.Transparent)
            ImagedText(text = "Bah à la péniche", image = R.drawable.localisation_icon)
            ImagedText(text = "18 Juin, 18h00", image = R.drawable.sun_icon)
        }


    }
}



@Composable
fun ImagedText(image: Int = R.drawable.localisation_icon, text:String) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = image),
            contentDescription = text,
            modifier = Modifier
                .height(13.dp)
                .width(13.dp)
        )
        Divider(modifier = Modifier.width(8.dp), color = Color.Transparent)
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif
        )
    }
}


@Composable
fun CardEventTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        maxLines = 2,
        modifier = modifier
    )
}

@Composable
fun CardEventTag(string: String, color: Color) {

    Shapes
    Surface(
        color = color,
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Text(
            text = string,
            fontSize = 10.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun CardEventTags(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        CardEventTag(string = "Chambery", color = BlueChambery)
        Divider(modifier = Modifier.width(8.dp), color = Color.Transparent)
        CardEventTag(string = "Afterwork", color = OrangeAfterWork)
    }
}


