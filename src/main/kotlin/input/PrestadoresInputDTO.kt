package desafio.input

data class PrestadoresInputDTO(
    val nome: String,
    val especialidade: List<String>,
    val endereco: String,
    val latitude: Double,
    val longitude: Double
)

