package com.example.happyschool.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.happyschool.R

@Composable
fun Dashboard(
    name: String,
    password: String
) {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        color = colorResource(R.color.teal_700)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Header("Dashboard", name)

            CustomWidget("GPA", "8.5", R.drawable.school_logo)
            CustomWidget("Attendance", "8.5", R.drawable.school_logo)
            CustomWidget("Assignment Due", "8.5", R.drawable.school_logo)
            CustomWidget("Assignment Graded", "8.5", R.drawable.school_logo)
            CustomWidget("School Bulletin", "8.5", R.drawable.school_logo)
            CustomWidget("Fees", "8.5", R.drawable.school_logo)


//            TextComponent(textValue = "Welcome $name", textSize = 18.sp )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    Dashboard(name = "Nikitha", password = "Password_1")
}