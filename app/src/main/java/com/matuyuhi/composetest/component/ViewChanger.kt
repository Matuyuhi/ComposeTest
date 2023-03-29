package com.matuyuhi.composetest.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.matuyuhi.composetest.R
import com.matuyuhi.feature.dashboard.HomeView
import com.matuyuhi.feature.dashboard.component.SearchBarPreView
import com.matuyuhi.feature.dashboard.R as dashboardR

data class ViewData(val compose: @Composable (()->Unit), val title: String)

@Composable
fun ViewChanger(
    views: ArrayList<ViewData> = arrayListOf(),
    modifier: Modifier = Modifier
) {
    var previewNum by remember {
        mutableStateOf(0)
    }
    var isPreview by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = dashboardR.color.primary_light_background))
    ){
        AnimatedVisibility(
            visible = isPreview,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .clickable { isPreview = false }
                        .weight(0.1f)
                ){
                    Text(
                        text = "back",
                        fontSize = 18.sp,
                        color = colorResource(id = dashboardR.color.text_tintcolor),
                        lineHeight = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .fillMaxWidth()
                ){
                    if (views.count() > previewNum) views[previewNum].compose()
                }
            }


        }
        AnimatedVisibility(
            visible = !isPreview,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(views.count()) {num ->
                    ViewButton(title=views[num].title, subtitle = "$num", onClick = {
                        previewNum = num
                        isPreview = true
                    })
                }
            }
        }
    }


}

@Composable
@Preview
fun ViewChangerPreview() {
    ViewChanger(arrayListOf(
        ViewData(compose = { SearchBarPreView() }, title="SearchBar"),
        ViewData(compose = { HomeView() }, title="HomeView")
    ))
}
