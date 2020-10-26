package desafio.`simuladorDistanciaKm-service`

import desafio.output.SimuladorDistanciaKmService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class SimuladorDistanciaKmServiceImpl(
    @Value("\${simuladorDistanciaKm.host}")
    private val host: String,
    @Value("\${simuladorDistanciaKm.obterDistancia}")
    private val obterDistancia: String
): SimuladorDistanciaKmService{

    override fun obterDistancia(latitudeOrigem: Double, latitudeDestino: Double, longitudeOrigem: Double, longitudeDestino: Double) : Double{
        val url = "$host$obterDistancia" + "?latitudeOrigem=" + latitudeOrigem + "&latitudeDestino=" + latitudeDestino + "&longitudeOrigem=" + longitudeOrigem + "&longitudeDestino=" + longitudeDestino

        try {
            val response = RestTemplate().getForObject(url, Double::class.java)
            return response
        } catch (e: Exception){
            throw e
        }

    }

}