package com.matuyuhi.feature.dashboard.component.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matuyuhi.feature.dashboard.R

@Composable
fun footerView(
    play: String = "0",
    clap: String = "0",
    comment: String = "0",
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 0.dp, bottom = 0.dp, end = 0.dp)
            .height(46.dp)
    ) {
        Box(
            Modifier.weight(0.8f)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 0.dp, bottom = 0.dp, end = 0.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .height(46.dp)
                .weight(1.1f)
        ) {

            Box(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        val styledText = buildAnnotatedString {

                            // 青色の"Hello"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tintcolor))) {
                                append(play)
                            }

                            // デフォルトスタイルの空白
                            append(" ")

                            // 緑色の"Android"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tint_subcolor))) {
                                append(" 回の再生")
                            }
                        }
                        Text(
                            text = styledText,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                    Divider(
                        color = colorResource(id = R.color.text_tint_subcolor),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        val styledText = buildAnnotatedString {

                            // 青色の"Hello"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tintcolor))) {
                                append(clap)
                            }

                            // デフォルトスタイルの空白
                            append(" ")

                            // 緑色の"Android"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tint_subcolor))) {
                                append(" 件の拍手")
                            }
                        }
                        Text(
                            text = styledText,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                    Divider(
                        color = colorResource(id = R.color.text_tint_subcolor),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        val styledText = buildAnnotatedString {

                            // 青色の"Hello"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tintcolor))) {
                                append(comment)
                            }

                            // デフォルトスタイルの空白
                            append(" ")

                            // 緑色の"Android"
                            withStyle(SpanStyle(color = colorResource(id = R.color.text_tint_subcolor))) {
                                append(" 件のコメント")
                            }
                        }
                        Text(
                            text = styledText,
                            color = colorResource(id = R.color.text_tintcolor),
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .wrapContentWidth(Alignment.CenterHorizontally),
                            fontSize = 11.sp

                        )
                    }
                }

            }
            Box(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth()
            )


        }
        Box(
            Modifier.weight(0.8f)
        )
    }

}

private fun convertFooterText(pic: String, sub: String) {

}

@Preview
@Composable
fun footerPreview(){
    footerView(
        modifier = Modifier
            .background(colorResource(id = R.color.post_background))
    )
}
