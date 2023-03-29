package com.matuyuhi.composetest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.matuyuhi.composetest.component.ViewChanger
import com.matuyuhi.composetest.component.ViewData
import com.matuyuhi.feature.dashboard.HomeView
import com.matuyuhi.feature.dashboard.component.SearchBarPreView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewChanger(arrayListOf(
                ViewData(compose = { SearchBarPreView() }, title="SearchBar"),
                ViewData(compose = { HomeView() }, title="Feed"),
            ))
        }
    }
}
