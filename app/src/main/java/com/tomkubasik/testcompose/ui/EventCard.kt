package com.tomkubasik.testcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomkubasik.testcompose.R
import com.tomkubasik.testcompose.ui.theme.Dimen

@Preview(showBackground = true)
@Composable
fun EventCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .width(126.dp),
        shape = RoundedCornerShape(Dimen.Core.corner_raduis_medium)
    ) {
        Column() {
            Image(
                painter = painterResource(R.drawable.beer),
                contentDescription = "beer",
                Modifier
                    .fillMaxWidth()
                    .height(53.dp)
                    .alpha(0.9f),
                contentScale = ContentScale.FillWidth
            )
            Column(
                Modifier.padding(
                    horizontal = Dimen.Core.spacing_medium,
                    vertical = Dimen.Core.spacing_small
                )
            ) {
                Text(
                    text = "Afterwork dans la pampa venez on va boire un coup",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(Dimen.Core.spacing_small))
                ImagedText(text = "Bah à la peniche", image = R.drawable.localisation_icon)
                ImagedText(text = "18 Juin, 18h00", image = R.drawable.sun_icon)
            }
        }
    }
}

@Composable
fun ImagedText(image: Int = R.drawable.localisation_icon, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "localisation_icon",
            tint = Color.Black,
            modifier = Modifier
                .height(10.dp)
                .width(10.dp)
                .alpha(0.9f),
        )
        Divider(modifier = Modifier.width(8.dp), color = Color.Transparent)
        Text(
            text = text,
            fontSize = 10.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
        )
    }
}