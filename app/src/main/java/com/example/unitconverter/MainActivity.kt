package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
//                Greeting(name = "Android",)
                UnitConverter()
                }
            }
        }
    }


@Composable
fun UnitConverter(){

    var Inputvalue by remember {
        mutableStateOf("")
    }
    var Outputvalue by remember {
        mutableStateOf("")
    }
    var iExpand by remember {
        mutableStateOf(false)
    }
    var inputunit by remember {
        mutableStateOf("Meters")
    }
    var Outputunit by remember {
        mutableStateOf("Meters")
    }
    var oExpanded by remember{
        mutableStateOf(false)
    }
    val conversion = remember {
        mutableStateOf(1.00)
    }
    val Oconversion = remember {
        mutableStateOf(1.00)
    }

    fun converter(){
        var InputDouble = Inputvalue.toDoubleOrNull() ?: 0.0
        var result = (InputDouble*conversion.value *100.0/Oconversion.value).roundToInt()/100.0
        Outputvalue = result.toString()


                }



    Column(
        modifier =  Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = Inputvalue, onValueChange = {
            Inputvalue = it
            converter()
        },
            label ={ Text(text = "Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //Input Box
               Box{
                   Button(onClick = { iExpand = true }) {
                       Text(text = inputunit)
                       Icon(Icons.Default.ArrowDropDown, contentDescription ="Down Arrow" )
                   }
    DropdownMenu(expanded =iExpand, onDismissRequest = { iExpand = false}) {
        DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/
                                iExpand = false
                                inputunit = "Centimerters"
                                conversion.value = 0.01
                                converter()

        })
        DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/
            iExpand = false
            inputunit = "Meters"
            conversion.value = 1.0
            converter()
        })
        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/
            iExpand = false
            inputunit = "Feet"
            conversion.value = 0.3048
            converter()
        })
        DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/
            iExpand = false
            inputunit = "Millimeters"
            conversion.value = 0.001
            converter()
        })
    }
               }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(Outputunit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="Arrrow Down" )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/
                        oExpanded = false
                        Outputunit = "Centimeters"
                        Oconversion.value = 0.01
                        if(inputunit == Outputunit){
                            Outputvalue = Inputvalue
                        }
                        else{
                        converter()
                    }
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/
                        oExpanded = false
                        Outputunit = "Meters"
                        Oconversion.value = 1.0
                        if(inputunit == Outputunit){
                            Outputvalue = Inputvalue
                        }
                        else{
                            converter()
                        }
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/
                        oExpanded = false
                        Outputunit = "Feet"
                        Oconversion.value = 0.3048
                        if(inputunit == Outputunit){
                            Outputvalue = Inputvalue
                        }
                        else{
                            converter()
                        }
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/
                        oExpanded = false
                        Outputunit = "Millimeters"
                        Oconversion.value = 0.001
                        if(inputunit == Outputunit){
                            Outputvalue = Inputvalue
                        }
                        else{
                            converter()
                        }
                    })
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result : $Outputvalue $Outputunit")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}


