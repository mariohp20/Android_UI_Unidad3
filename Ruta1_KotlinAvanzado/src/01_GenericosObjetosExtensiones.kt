/**
 * RUTA 1 - Parámetros genéricos, objetos y extensiones
 * Ejemplos de genéricos, enum, data class, singleton, companion object
 * y funciones/propiedades de extensión.
 */

// GENÉRICOS: esta clase puede "envolver" cualquier tipo de dato sin repetir código
class Caja<T>(val contenido: T) {
    fun mostrarContenido(): String = "La caja contiene: $contenido"
}

// ENUM CLASS: define un conjunto limitado y fijo de valores posibles
enum class Categoria {
    ELECTRONICA, ROPA, ALIMENTOS
}

// DATA CLASS: Kotlin genera automáticamente toString(), equals(), copy(), etc.
data class Producto(val nombre: String, val precio: Double, val categoria: Categoria)

// OBJECT (singleton): esta clase solo puede tener UNA instancia en toda la app
object Inventario {
    private val productos = mutableListOf<Producto>()

    fun agregar(producto: Producto) {
        productos.add(producto)
    }

    fun listar(): List<Producto> = productos
}

// CLASE con COMPANION OBJECT: permite crear una especie de "método estático"
class Descuento(val porcentaje: Double) {
    companion object {
        fun sinDescuento() = Descuento(0.0)
    }
}

// FUNCIÓN DE EXTENSIÓN: le agrego una capacidad nueva a Double sin modificar su clase original
fun Double.aFormatoPrecio(): String = "S/ %.2f".format(this)

// PROPIEDAD DE EXTENSIÓN (de solo lectura): agrego una propiedad calculada a String
val String.iniciales: String
    get() = this.split(" ").joinToString("") { it.first().uppercase() }

fun main() {
    // Uso de genéricos con distintos tipos de dato en la misma clase
    val cajaDeTexto = Caja("Kotlin")
    val cajaDeNumero = Caja(42)
    println(cajaDeTexto.mostrarContenido())
    println(cajaDeNumero.mostrarContenido())

    // Uso de enum + data class
    val producto1 = Producto("Laptop", 3200.0, Categoria.ELECTRONICA)
    val producto2 = Producto("Polo", 45.0, Categoria.ROPA)

    Inventario.agregar(producto1)
    Inventario.agregar(producto2)
    println("\nInventario actual: ${Inventario.listar()}")

    // Uso de companion object como "fábrica" de objetos
    val descuentoBase = Descuento.sinDescuento()
    println("\nDescuento por defecto: ${descuentoBase.porcentaje}%")

    // Uso de funciones/propiedades de extensión
    println("\nPrecio formateado: ${producto1.precio.aFormatoPrecio()}")
    println("Iniciales de 'Mario Huarcaya': ${"Mario Huarcaya".iniciales}")

    // FUNCIONES DE ALCANCE (scope functions)
    producto1.let {
        println("\n[let] Analizando producto: ${it.nombre}, cuesta ${it.precio.aFormatoPrecio()}")
    }

    val resultadoRun = producto2.run {
        "[run] $nombre pertenece a la categoría $categoria"
    }
    println(resultadoRun)
}
