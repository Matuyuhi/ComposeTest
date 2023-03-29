package com.matuyuhi.feature.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matuyuhi.feature.dashboard.component.post.PostView


data class UserDataModel(val name: String, val iconId: Int)
@Composable
fun HomeView() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.primary_background))
    ){
        PostView(title="Super Freaky Girl", UserDataModel("tsuji", R.mipmap.sample_usericon01))
        Spacer(modifier = Modifier.height(10.dp))
        PostView(title="Anti-Hero", UserDataModel("matsuzaki", R.mipmap.sample_usericon02))
        Spacer(modifier = Modifier.height(10.dp))
        PostView(title="As It Was", UserDataModel("matsuzaki", R.mipmap.sample_usericon03))
        Spacer(modifier = Modifier.height(10.dp))
    }
}


@Preview
@Composable
fun HomeViewPreview() {
    HomeView()
}