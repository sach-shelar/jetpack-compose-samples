package com.sach.designcomponents.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sach.designcomponents.R

//Modifier
//Conditional Modifier
@Composable
fun TestModifiers(condition: Boolean = true) {
    //Modifier Order Matters.
    Column(modifier = Modifier
        .padding(40.dp)
        .background(Color.Gray)
        .then(
            other = if(condition) {
                Modifier.border(width = 10.dp, color = Color.Green)
            }else{
                Modifier.border(width = 10.dp, color = Color.Red)
            }
        )
        .padding(20.dp)
        .clickable { }) {
        Text(text = stringResource(R.string.str_india), modifier = Modifier.textModifier2())
    }
}


//Custom Modifiers with Compose
fun Modifier.textModifier():Modifier = composed {
    padding(16.dp)
    border(1.dp,Color.Green)
}

//Custom Modifiers return object
fun Modifier.textModifier2():Modifier  {
    return this.padding(16.dp).border(1.dp,Color.Yellow)
}

