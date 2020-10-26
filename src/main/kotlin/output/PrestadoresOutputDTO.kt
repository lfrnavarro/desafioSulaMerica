package desafio.output

data class PrestadoresOutputDTO(
    val nome: String,
    val endereco: String,
    val latitude: Double,
    val longitude: Double,
    val distanciaEmKm: Double
)

