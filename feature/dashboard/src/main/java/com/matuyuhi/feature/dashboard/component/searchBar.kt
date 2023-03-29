package com.matuyuhi.feature.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.matuyuhi.feature.dashboard.R

@Composable
fun SearchBar(
    onValueChange: ((String)->Unit) = {},
    modifier: Modifier = Modifier
) {
    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {
            value = it
            onValueChange(value)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.search_placeholder))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp, max = 56.dp)
    )
}

@Preview
@Composable
fun SearchBarPreView() {
    SearchBar(
        onValueChange = {value ->
            println("SearchBar value : $value")
        }
    )
}