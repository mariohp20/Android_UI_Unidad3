/**
 * RUTA 1 - Colecciones en Kotlin
 * Ejemplos de Array, List, Set y Map.
 */

fun main() {
    // ARRAY: tamaño fijo, mismo tipo de dato, acceso rápido por índice
    val precios = arrayOf(10.5, 20.0, 15.75, 8.0)
    println("Array de precios: ${precios.joinToString()}")
    println("Precio en el índice 2: ${precios[2]}")

    // LIST: colección ORDENADA y de tamaño variable
    val frutas = mutableListOf("Manzana", "Pera", "Uva")
    frutas.add("Plátano")
    println("\nLista de frutas: $frutas")
    println("Fruta en el índice 1: ${frutas[1]}")

    // SET: colección SIN orden garantizado y SIN duplicados
    val categoriasVistas = setOf("Electrónica", "Ropa", "Electrónica", "Alimentos")
    println("\nSet de categorías (nota que no se repite 'Electrónica'): $categoriasVistas")

    // MAP: pares clave-valor, acceso rápido por clave usando código hash
    val preciosPorProducto = mapOf(
        "Laptop" to 3200.0,
        "Polo" to 45.0,
        "Zapatillas" to 180.0
    )
    println("\nMapa de precios: $preciosPorProducto")
    println("Precio de 'Polo': ${preciosPorProducto["Polo"]}")

    // Recorrido simple de un mapa
    println("\nRecorriendo el mapa:")
    for ((producto, precio) in preciosPorProducto) {
        println("- $producto cuesta S/$precio")
    }
}
