//package com.example.noveltoon.presentation.screen.splash
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import com.example.myapplication.R
//import kotlinx.coroutines.delay
//
//@Composable
//fun SplashScreen(
//    onNavigateNext: () -> Unit
//) {
//
//    LaunchedEffect(true) {
//        delay(2000)
//        onNavigateNext()
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFF6FA8DC)),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Image(
//            painter = painterResource(id = R.drawable.splash),
//            contentDescription = "Splash",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }
//}