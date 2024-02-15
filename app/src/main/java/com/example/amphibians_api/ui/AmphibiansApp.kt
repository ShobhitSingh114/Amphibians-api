package com.example.amphibians_api.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import com.example.amphibians_api.R
import com.example.amphibians_api.ui.screens.HomeScreen

@Composable
fun AmphibiansApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AmphibiansAppTopBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen()
        }
        val contentPadding = it
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansAppTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        modifier = modifier,
//        colors = topAppBarColors(Blue)
    )
}
