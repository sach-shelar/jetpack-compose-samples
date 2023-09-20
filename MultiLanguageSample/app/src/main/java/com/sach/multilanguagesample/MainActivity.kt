package com.sach.multilanguagesample

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sach.multilanguagesample.ui.theme.MultiLanguageSampleTheme
import java.util.Locale

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLanguageSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        UserDetails()
                        Spacer(modifier = Modifier.padding(20.dp))
                        BottomButtons(changeAppLang = ::changeAppLang)
                    }
                }
            }
        }
    }

    private fun changeAppLang(languageCode:String){
        val appLocal = Locale(languageCode)
        Locale.setDefault(appLocal)
        val configuration = Configuration().apply {
            setLocale(appLocal)
        }
        resources.updateConfiguration(configuration, resources.displayMetrics)
        recreate()
    }


}


@Composable
fun UserDetails() {
    Spacer(modifier = Modifier.padding(20.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = stringResource(R.string.str_west), color = Color.Black)
            Text(text = stringResource(R.string.str_north), color = Color.Black)
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = stringResource(R.string.str_south), color = Color.Black)
            Text(text = stringResource(R.string.str_east), color = Color.Black)
        }
    }
}

@Composable
fun BottomButtons(changeAppLang: (String) -> Unit) {
    var appLocal by remember { mutableStateOf(Locale.getDefault()) }


    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {
            changeAppLang("en")
        }) {
            Text(text = stringResource(R.string.str_english))
        }

        Button(onClick = {
            changeAppLang("fr")

        }) {
            Text(text = stringResource(R.string.str_french))
        }
    }
    Spacer(modifier = Modifier.padding(20.dp))

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiLanguageSampleTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            UserDetails()
            Spacer(modifier = Modifier.padding(20.dp))
            //BottomButtons()
        }
    }
}