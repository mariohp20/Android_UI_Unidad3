package com.example.tipsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tipsapp.ui.theme.TipsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // TipsAppTheme lo genera Android Studio al crear el proyecto.
            // Ahí mismo (carpeta ui/theme/) puedes cambiar colores, formas y tipografía
            // para cumplir con la parte de Material Design del desafío.
            TipsAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipsApp()
                }
            }
        }
    }
}