package com.example.noveltoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.noveltoon.presentation.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint
import com.example.noveltoon.core.ui.theme.NoveltoonTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//
//        splashScreen.setKeepOnScreenCondition {
//            // giữ splash trong 2s
//            System.currentTimeMillis() % 10000 < 3000
//        }
        setContent {
            MainApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    NoveltoonTheme {
//        Greeting("Android")
//    }
}