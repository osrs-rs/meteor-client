package meteor.ui.composables.nodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.ui.composables.darkThemeColors
import meteor.ui.composables.uiColor


@Composable
fun sliderIntNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {

    var sliderValue by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )
    }
    var setConfigValue by remember {
        mutableStateOf(
            ConfigManager.stringToObject(
                sliderValue.toString(),
                Int::class.java
            ) as Int
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(46.dp).background(Color(0xFF242424))) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.5f).height(46.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor, fontSize = 14.sp))
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(46.dp).background(Color(0xFF242424))
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(
                    text = setConfigValue.toString(),
                    modifier = Modifier.padding(8.dp).width(46.dp),
                    style = TextStyle(color = uiColor, fontSize = 14.sp, textAlign = TextAlign.Center)
                )
                Spacer(Modifier.width(5.dp).background(darkThemeColors.background))
                Slider(
                    value = sliderValue!!.toFloat(),
                    onValueChange = {
                        sliderValue = setConfigValue.toString()
                        setConfigValue = it.toInt()
                        ConfigManager.setConfiguration(
                            descriptor.group.value,
                            configItemDescriptor.key(),
                            it.toInt()
                        )
                    },
                    valueRange = configItemDescriptor.range!!.min.toFloat()..configItemDescriptor.range.max.toFloat(),
                    modifier = Modifier.height(12.dp).background(darkThemeColors.background),
                    colors = SliderDefaults.colors(thumbColor = uiColor, activeTrackColor = uiColor, inactiveTrackColor = Color.Gray)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun intAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))) {

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(100.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(all = 3.dp),
                    value = text,
                    onValueChange = {
                        text = it
                        ConfigManager.setConfiguration(
                            descriptor.group.value,
                            configItemDescriptor.key(),
                            it
                        )
                    },
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    maxLines = 30,
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun intTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(60.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().height(60.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(all = 3.dp),
                    value = text,
                    visualTransformation = if (configItemDescriptor.secret()) PasswordVisualTransformation() else VisualTransformation.None,
                    onValueChange = {
                        text = it
                        ConfigManager.setConfiguration(
                            descriptor.group.value, configItemDescriptor.key(),
                            it
                        )

                    },
                    maxLines = 30,
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}