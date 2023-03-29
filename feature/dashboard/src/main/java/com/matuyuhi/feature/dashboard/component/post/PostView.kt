package com.matuyuhi.feature.dashboard.component.post

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.matuyuhi.feature.dashboard.R
import com.matuyuhi.feature.dashboard.UserDataModel


@Composable
fun PostView(
    title: String = "",
    user: UserDataModel,
    onClickInfo: (()-> Unit) = {}
){
    Column() {
        UserInfo(
            title = title, username = user.name,
            iconId = user.iconId,
            onClickInfo = {println("click button more")},
            modifier = Modifier
                .background(colorResource(id = R.color.post_background))
        )
        footerView(
            modifier = Modifier
                .background(colorResource(id = R.color.post_background))
        )
    }

}

@Preview
@Composable
fun PostViewPreview() {
    PostView(title = "Anti-Hero",
        user = UserDataModel("matsuzaki", R.mipmap.sample_usericon01),
        onClickInfo = {}
    )
}