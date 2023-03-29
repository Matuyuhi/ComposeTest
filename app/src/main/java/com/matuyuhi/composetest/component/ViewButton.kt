package com.matuyuhi.composetest.component

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matuyuhi.feature.dashboard.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ViewButton(
    title: String = "",
    subtitle: String = "",
    onClick: (()->Unit) = {}
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .background(
                color = colorResource(id =  R.color.primary_background),
                shape = RoundedCornerShape(10.dp)
            )
            .height(50.dp),
    ) {
        Row(
            modifier = Modifier
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_tintcolor),
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_tint_subcolor),
                    modifier = Modifier
                        .weight(0.6f)
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.3f)
            )
        }
    }
//    Button(
//        onClick = {},
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = colorResource(id = com.matuyuhi.feature.dashboard.R.color.post_background)
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(min = 56.dp, max = 56.dp)
//    ){
//
//    }
}

@Preview
@Composable
fun ViewButtonPreview() {
    ViewButton(title="comp1", subtitle="testtesttest", onClick = {println("Preview click")

    })
}
