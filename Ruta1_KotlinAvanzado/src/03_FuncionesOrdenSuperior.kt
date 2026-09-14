/**
 * RUTA 1 - Funciones de orden superior con colecciones
 * Ejemplos de forEach, map, filter, groupBy, fold y sortedBy.
 */

data class Estudiante(val nombre: String, val nota: Double)

fun main() {
    val estudiantes = listOf(
        Estudiante("Ana", 15.5),
        Estudiante("Luis", 9.0),
        Estudiante("Marco", 18.0),
        Estudiante("Sofia", 11.5),
        Estudiante("Diego", 6.5)
    )

    // forEach(): aplica una acción a cada elemento de la colección
    println("--- forEach ---")
    estudiantes.forEach { estudiante ->
        println("${estudiante.nombre} tiene nota ${estudiante.nota}")
    }

    // map(): transforma cada elemento en otro dato (aquí, solo el nombre)
    val nombres = estudiantes.map { it.nombre }
    println("\n--- map ---")
    println("Solo los nombres: $nombres")

    // filter(): genera un subconjunto que cumple una condición
    val aprobados = estudiantes.filter { it.nota >= 10.5 }
    println("\n--- filter ---")
    println("Aprobados: ${aprobados.map { it.nombre }}")

    // groupBy(): divide la colección según el resultado de una función
    val agrupadosPorEstado = estudiantes.groupBy { if (it.nota >= 10.5) "Aprobado" else "Desaprobado" }
    println("\n--- groupBy ---")
    println(agrupadosPorEstado)

    // fold(): reduce toda la colección a un solo valor, partiendo de un valor inicial
    val sumaDeNotas = estudiantes.fold(0.0) { acumulado, estudiante -> acumulado + estudiante.nota }
    val promedio = sumaDeNotas / estudiantes.size
    println("\n--- fold ---")
    println("Promedio del salón: %.2f".format(promedio))

    // sortedBy(): ordena la colección según una propiedad
    val ordenadosPorNota = estudiantes.sortedBy { it.nota }
    println("\n--- sortedBy ---")
    println("De menor a mayor nota: ${ordenadosPorNota.map { "${it.nombre} (${it.nota})" }}")
}
