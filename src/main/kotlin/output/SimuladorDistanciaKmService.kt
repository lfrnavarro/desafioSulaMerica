package desafio.output

interface SimuladorDistanciaKmService {
    fun obterDistancia(latitudeOrigem: Double, latitudeDestino: Double, longitudeOrigem: Double, longitudeDestino: Double) : Double
}