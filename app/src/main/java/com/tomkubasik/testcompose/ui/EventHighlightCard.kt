package com.tomkubasik.testcompose

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.tomkubasik.testcompose.ui.theme.BlueChambery
import com.tomkubasik.testcompose.ui.theme.Dimen
import com.tomkubasik.testcompose.ui.theme.OrangeAfterWork
import com.tomkubasik.testcompose.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun EventHighlightCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .width(Dimen.EventCard.width),
        shape = RoundedCornerShape(Dimen.Core.corner_raduis_medium)

    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.beer),
                contentDescription = "beer",
                Modifier
                    .fillMaxWidth()
                    .height(Dimen.EventCard.image_height)
                    .alpha(0.9f),
                contentScale = ContentScale.FillWidth
            )
            ConstraintLayout(modifier = Modifier.padding(Dimen.Core.spacing_medium)) {
                val (column, goingTag, goingPeople) = createRefs()
                Column(
                    Modifier.constrainAs(column) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                ) {
                    CardEventTags()
                    CardEventTitle(text = "Afterwork dans la pampa, venez on va boire un coup")
                    Divider(Modifier.height(Dimen.Core.spacing_small), color = Color.Transparent)
                    ImagedText(text = "Bah à la péniche", image = R.drawable.localisation_icon)
                    ImagedText(text = "18 Juin, 18h00", image = R.drawable.sun_icon)
                }
                GoingTag(modifier = Modifier.constrainAs(goingTag) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })
                GoingPeopleImages(modifier = Modifier.constrainAs(goingPeople) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })

            }
        }
    }
}


@Composable
fun ImagedText(image: Int = R.drawable.localisation_icon, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
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
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light
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
    Row(
        modifier = modifier
    ) {
        CardEventTag(string = "Chambery", color = BlueChambery)
        Divider(modifier = Modifier.width(Dimen.Core.spacing_medium), color = Color.Transparent)
        CardEventTag(string = "Afterwork", color = OrangeAfterWork)
    }
}


@Composable
fun GoingTag(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "J'y vais",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(R.drawable.check_icon),
            contentDescription = "check",
            modifier = Modifier
                .height(13.dp)
                .width(13.dp)
        )


    }
}


@Composable
fun GoingPeopleImages(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        Image(
            painter = painterResource(id = R.drawable.tomkubasik), contentDescription = "Moi",
            modifier = Modifier
                .offset(0.dp, 0.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(24.dp)
                .height(24.dp)
                .alpha(0.7f)

        )
        Image(
            painter = painterResource(id = R.drawable.tomkubasik), contentDescription = "Moi",
            modifier = Modifier
                .offset((-10).dp, 0.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(24.dp)
                .height(24.dp)
                .alpha(0.8f)
        )
        Image(
            painter = painterResource(id = R.drawable.tomkubasik), contentDescription = "Moi",
            modifier = Modifier
                .offset((-20).dp, 0.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(24.dp)
                .height(24.dp)
                .alpha(0.9f)
        )
        Image(
            painter = painterResource(id = R.drawable.tomkubasik), contentDescription = "Moi",
            modifier = Modifier
                .offset((-30).dp, 0.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(24.dp)
                .height(24.dp)
                .alpha(1f)
        )
    }

}


