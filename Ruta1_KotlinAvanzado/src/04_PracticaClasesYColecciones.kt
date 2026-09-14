/**
 * RUTA 1 - Práctica: Clases y colecciones
 * Combina data classes y funciones de orden superior en un solo caso práctico:
 * un reporte de notas de un salón, resuelto en 7 tareas.
 */

data class Alumno(val nombre: String, val nota: Double, val categoria: String)

fun main() {
    // Tarea 1: crear la lista de alumnos usando una data class
    val salon = listOf(
        Alumno("Ana", 15.5, "Regular"),
        Alumno("Luis", 9.0, "Regular"),
        Alumno("Marco", 18.0, "Becado"),
        Alumno("Sofia", 11.5, "Becado"),
        Alumno("Diego", 6.5, "Regular"),
        Alumno("Valeria", 17.0, "Regular")
    )
    println("Tarea 1 - Lista creada con ${salon.size} alumnos")

    // Tarea 2: filtrar solo los aprobados (nota >= 10.5)
    val aprobados = salon.filter { it.nota >= 10.5 }
    println("Tarea 2 - Aprobados: ${aprobados.map { it.nombre }}")

    // Tarea 3: calcular el promedio general del salón con fold
    val promedio = salon.fold(0.0) { acc, alumno -> acc + alumno.nota } / salon.size
    println("Tarea 3 - Promedio del salón: %.2f".format(promedio))

    // Tarea 4: ordenar a los alumnos de mayor a menor nota
    val ordenadosDesc = salon.sortedByDescending { it.nota }
    println("Tarea 4 - Ranking: ${ordenadosDesc.map { "${it.nombre} (${it.nota})" }}")

    // Tarea 5: agrupar por categoría (Regular / Becado)
    val porCategoria = salon.groupBy { it.categoria }
    println("Tarea 5 - Agrupados por categoría: $porCategoria")

    // Tarea 6: transformar la lista en strings con formato de reporte
    val reporte = salon.map { "${it.nombre}: ${if (it.nota >= 10.5) "Aprobado" else "Desaprobado"}" }
    println("Tarea 6 - Reporte individual:")
    reporte.forEach { println("  $it") }

    // Tarea 7: recorrer y mostrar un resumen final
    println("\nTarea 7 - Resumen final:")
    println("Total de alumnos: ${salon.size}")
    println("Aprobados: ${aprobados.size} | Desaprobados: ${salon.size - aprobados.size}")
}
