package com.example.happyschool.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.happyschool.ui.screens.SchoolAppNavigationGraph
import com.example.happyschool.ui.theme.HappySchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            HappySchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SchoolApp()
                }
            }
        }
    }
}

@Composable
fun SchoolApp() {
    SchoolAppNavigationGraph()
}

@Preview(showBackground = true)
@Composable
fun SchoolAppPreview() {
    HappySchoolTheme {
        SchoolApp()
    }
}