package com.example.happyschool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happyschool.R

@Composable
fun TopBar(textEntered: String, size: Dp) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = textEntered,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(size),
            painter = painterResource(id = R.drawable.school_logo), contentDescription = "Logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarView() {
    TopBar("Hello,\nWelcome to Happy \nSchool Application", 125.dp)
}

@Composable
fun Header(headerTitle: String, headerName:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.teal_200)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(130.dp,0.dp,0.dp,0.dp),
                text = headerTitle,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(130.dp,0.dp,0.dp,0.dp),
                text = headerName,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .size(45.dp)
                .padding(5.dp),
            painter = painterResource(id = R.drawable.person), contentDescription = "Logo"
        )
    }

}

@Preview
@Composable
fun HeaderPreview(){
Header("Title","Name")
}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, colorValue: Color = Color.Black) {

    androidx.compose.material.Text(
        modifier = Modifier.padding(10.dp),
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Composable
fun TitlesEntered(
    textUsed: String,
    maxChar: Int,
    onTextChanged: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            if (it.length<= maxChar) currentValue = it
            onTextChanged(it)
        },

        placeholder = {
            androidx.compose.material.Text(
                text = textUsed,
                fontSize = 18.sp
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun TextField(
    onTextChanged: (name: String) -> Unit,
    maxChar: Int
) {
    var currentValue by remember {mutableStateOf("") }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            if (it.length<= maxChar ) currentValue = it
            onTextChanged(it)
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun ShowErrorMessage(){
    TextComponent(textValue = "Enter Valid Text", textSize = 15.sp)
}

@Preview(showBackground = true)
@Composable
fun TextFieldView() {
    TextField(onTextChanged = {},8)
}


@Composable
fun ButtonComponent(
    buttonText: String,
    goToDetailsScreen: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .wrapContentWidth()
            .padding(25.dp),
        onClick = {
            goToDetailsScreen()
        }

    ) {
        Text(
            text = buttonText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

    }

}

@Composable
fun CustomWidget(widgetName: String , widgetScore: String, widgetIcon: Int) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .background(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {

            Text(text = widgetName, modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp, 0.dp, 0.dp, 0.dp),
                color = colorResource(R.color.brown))

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = widgetScore,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            Image(
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(widgetIcon),
                contentDescription = "Quote Image"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomWidgetPreivew() {
    CustomWidget("GPA","8.5",R.drawable.school_logo)
}

@Composable
fun FooterColumn(textEntered : String){
    Column (modifier = Modifier
        .wrapContentSize()
        .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
    Image(
        modifier = Modifier.size(40.dp),
        painter = painterResource(id = R.drawable.school_logo), contentDescription = "Logo"
    )
    Text(
        text = textEntered,
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}
}


@Composable
fun Footer(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        FooterColumn(textEntered = "Dashboard")
        Spacer(modifier = Modifier.size(15.dp))
        FooterColumn(textEntered = "Classes")
        Spacer(modifier = Modifier.size(15.dp))
        FooterColumn(textEntered = "Calender")
        Spacer(modifier = Modifier.size(15.dp))
        FooterColumn(textEntered = "Schedule")


    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview(){
    ButtonComponent("kjkj",{})
}


