package com.matuyuhi.feature.test

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun testView(name: String) {
    Text(text = "Hello $name !!!")
}

@Preview
@Composable
fun testViewView() {
    testView(name = "yuhi")
}