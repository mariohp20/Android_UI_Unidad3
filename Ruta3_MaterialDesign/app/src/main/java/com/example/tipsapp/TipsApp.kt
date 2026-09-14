package com.example.tipsapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * DESAFÍO FINAL - App de 30 tips
 * Combina lo aprendido en la Unidad 3:
 * - Ruta 2: lista desplazable (LazyColumn) con datos de una data class
 * - Ruta 3: Material Design (colores, formas, tipografía) + animación simple
 */

// Cambia el tema y el texto de cada tip por lo que tú elijas
data class Tip(val dia: Int, val texto: String)

fun generarListaDeTips(): List<Tip> {
    val textos = listOf(
        "Estudia en bloques de 25 minutos con descansos cortos (técnica Pomodoro).",
        "Repasa tus apuntes el mismo día de la clase, no esperes al examen.",
        "Duerme al menos 7 horas antes de un día de exámenes.",
        "Explica lo que aprendiste en voz alta como si le enseñaras a alguien más.",
        "Elimina notificaciones del celular mientras estudias.",
        "Organiza tus tareas por prioridad, no por lo más fácil primero.",
        "Toma agua mientras estudias, la deshidratación afecta la concentración.",
        "Usa colores distintos para diferenciar temas en tus apuntes.",
        "Haz preguntas en clase aunque creas que son básicas.",
        "Divide un proyecto grande en tareas pequeñas con fechas propias."
        // Agrega el resto de tus 30 tips aquí; si se acortan, se repiten cíclicamente abajo
    )
    return (1..30).map { dia ->
        Tip(dia = dia, texto = textos[(dia - 1) % textos.size])
    }
}

@Composable
fun TipsApp() {
    val tips = remember { generarListaDeTips() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("30 Tips para Estudiar Mejor") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            items(tips) { tip ->
                TipCard(tip)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun TipCard(tip: Tip) {
    // Estado propio de esta tarjeta: si está expandida o no
    var expandido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expandido = !expandido }
            .animateContentSize(), // ANIMACIÓN: suaviza el cambio de tamaño de la tarjeta
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Día ${tip.dia}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Icon(
                    imageVector = if (expandido) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    // ACCESIBILIDAD: describe la acción del ícono para lectores de pantalla
                    contentDescription = if (expandido) "Contraer tip" else "Expandir tip"
                )
            }

            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tip.texto,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}