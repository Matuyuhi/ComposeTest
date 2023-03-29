package com.matuyuhi.feature.test

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// rememberとmutableStateOfに必須
// -----
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
// -----


@Preview
@Composable
fun testViewView() {
    Sample_MessageView_custom(TestData("User", "member"))
}

@Preview(name = "LightMode")
@Preview(
    name = "DarkMode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun ComposeThemeView() {
    Sample_MessageView_custom(TestData("User", "member"))
}
data class TestData(val auth: String, val body: String)
@Composable
fun testView(data: TestData) {
    Text(text = "Hello ${data.auth} !!!")
    Text(text = "your ${data.body} !!!")
}

@Composable
// Columnで縦に (Linear)
fun Sample_ColumnView(data: TestData) {
    Column{
        Text(text = "Hello ${data.auth} !!!")
        Text(text = "your ${data.body} !!!")
    }
}

@Composable
// Columnで縦に (Linear)
fun Sample_UserView(data: TestData) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture"
        )
        Column {
            Text(text = "Hello ${data.auth} !!!")
            Text(text = "your ${data.body} !!!")
        }

    }
}

@Composable
// res/themes/themes.xml参照
fun Sample_MessageView_custom(msg: TestData) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // resize
                .size(40.dp)
                // imageを円形にトリム
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.error)
                .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
        )

        // imageとColumnのスペース
        Spacer(modifier = Modifier.width(10.dp))

        // variable rememberでメモリに格納して、変更をトラッキング
        // このあたり使う時は
        var isExpanded by remember { mutableStateOf<Boolean>(false) }

        // click時の色の指定
        val surfaceColor by animateColorAsState(
            if (isExpanded)
                MaterialTheme.colorScheme.inversePrimary
            else
                MaterialTheme.colorScheme.background
        )
        // click したら boolの切り替え
        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Surface(shape = MaterialTheme.shapes.large) {
                Text(
                    text = msg.auth,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            // 上下のスペース
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                tonalElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.bodySmall,
                    //clickで表示する行数を 1 or maxに変更
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }

        }
    }
}


@Composable
// Rowで水平に並べる
fun Sample_RowView(data: TestData) {
    Row {
        Text(text = "Hello ${data.auth} !!!")
        Text(text = "your ${data.body} !!!")
    }
}

@Composable
fun MessageViewList(lists: List<TestData>) {
    LazyColumn {
        items(lists) {data ->
            Sample_MessageView_custom(data)
            
        }
    }
}

@Preview
@Composable
fun UserViewListPreview() {
    MessageViewList(
        arrayListOf(
            TestData("user","This is UserViewList function PreView!!!\nis \nCustom \nList"),
            TestData("hoge","Let's \nenjoy!!"),
            TestData("hoge","helloo"),
            TestData("hoge","h\ne\nl\nl\no"),
            TestData("hoge1","helloo"),
            TestData("hoge2","helloo"),
            TestData("hoge3","helloo"),
            TestData("hoge4","helloo"),
            TestData("hoge5","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
            TestData("hoge","helloo"),
        )
    )
}

