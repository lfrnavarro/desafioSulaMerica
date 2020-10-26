package desafio.usecase

import desafio.input.Atendimento
import desafio.input.PrestadoresInputDTO
import desafio.output.PrestadoresOutputDTO
import desafio.output.SimuladorDistanciaKmService
import org.springframework.stereotype.Service

@Service
class AtendimentoUseCase(
    val simuladorDistanciaKmService: SimuladorDistanciaKmService
) : Atendimento {

    override fun obterPrestadoresSaude(latitude: Double, longitude: Double, especialidade : String): List<PrestadoresOutputDTO>{
        val listPrestadoresInputDTO = init()
        val listPrestadoresOutputDTO = mutableListOf<PrestadoresOutputDTO>()
        listPrestadoresInputDTO.forEach{
            medico ->
            if(medico.especialidade.contains(especialidade)){
                listPrestadoresOutputDTO.add(
                    PrestadoresOutputDTO(
                        nome = medico.nome,
                        endereco = medico.endereco,
                        latitude = medico.latitude,
                        longitude = medico.longitude,
                        distanciaEmKm = simuladorDistanciaKmService.obterDistancia(latitude, medico.latitude, longitude, medico.longitude)
                    )
                )
            }
        }

        return listPrestadoresOutputDTO.sortedBy { medico -> medico.distanciaEmKm }
    }

    fun init() : List<PrestadoresInputDTO>{
        return listOf(
            PrestadoresInputDTO(
                nome = "Luciana",
                especialidade = listOf("Cardiologia", "Ortopedia"),
                endereco = "Rua Um, 1",
                latitude = -1.860212,
                longitude = -1.00212
            ),
            PrestadoresInputDTO(
                nome = "Marcio",
                especialidade = listOf("Cardiologia", "Ortopedia", "Oftalmologia", "Clínico"),
                endereco = "Rua Dois, 2",
                latitude = -2.860212,
                longitude = -2.00212
            ),
            PrestadoresInputDTO(
                nome = "Marcelo",
                especialidade = listOf("Cardiologia"),
                endereco = "Rua Três, 3",
                latitude = -3.860212,
                longitude = -3.00212
            ),
            PrestadoresInputDTO(
                nome = "Ana",
                especialidade = listOf("Clínico", "Oftalmologia"),
                endereco = "Rua quatro, 4",
                latitude = -4.860212,
                longitude = -4.00212
            ),
            PrestadoresInputDTO(
                nome = "Beatriz",
                especialidade = listOf("Clínico"),
                endereco = "Rua cinco, 5",
                latitude = -5.860212,
                longitude = -5.00212
            ),
            PrestadoresInputDTO(
                nome = "Joana",
                especialidade = listOf("Cardiologia", "Ortopedia", "Oftalmologia", "Clínico"),
                endereco = "Rua seis, 6",
                latitude = -6.860212,
                longitude = -6.00212
            ),
            PrestadoresInputDTO(
                nome = "Magno",
                especialidade = listOf("Cardiologia", "Ortopedia", "Oftalmologia", "Clínico"),
                endereco = "Rua sete, 7",
                latitude = -7.860212,
                longitude = -7.00212
            ),
            PrestadoresInputDTO(
                nome = "Gustavo",
                especialidade = listOf("Pediatra"),
                endereco = "Rua oito, 8",
                latitude = -8.860212,
                longitude = -8.00212
            ),
            PrestadoresInputDTO(
                nome = "Renato",
                especialidade = listOf("Ortopedia", "Oftalmologia"),
                endereco = "Rua nove, 9",
                latitude = -9.860212,
                longitude = -9.00212
            ),
            PrestadoresInputDTO(
                nome = "Bruno",
                especialidade = listOf("Oftalmologia"),
                endereco = "Rua dez, 10",
                latitude = -10.860212,
                longitude = -10.00212
            )
        )
    }

}