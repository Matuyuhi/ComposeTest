package com.matuyuhi.feature.dashboard.component.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matuyuhi.feature.dashboard.R

@Composable
fun UserInfo(
    title: String,
    username: String,
    iconId: Int,
    onClickInfo: (()->Unit) = {},
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
    ){

        Image(
            painter = painterResource(iconId),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .weight(5f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)

            ){
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(1.dp)
                        .height(IntrinsicSize.Min),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.text_tintcolor)
                )
            }
            Text(
                text = username + " * Vocal * 1時間前",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontSize = 8.sp,
                color = colorResource(id = R.color.text_tint_subcolor)

            )
        }
        Box (
            modifier = Modifier
                .weight(1f)
        ){
            Row (){
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                )
                IconButton(
                    onClick = onClickInfo,

                    modifier = Modifier
                        .wrapContentWidth(Alignment.End)
                        .weight(2f)
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = null,
                        modifier = Modifier
                            .height(90.dp)
                            .aspectRatio(1f)
                    )
                }
            }

        }


    }
}

@Composable
@Preview
fun UserInfoPreView(){
    UserInfo(
        title="Anti-Hero",
        username = "matsuzaki",
        iconId = R.mipmap.sample_usericon02,
        onClickInfo = {},
        modifier = Modifier
            .background(colorResource(id = R.color.post_background))
    )
}