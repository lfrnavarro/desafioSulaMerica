package desafio.input

import desafio.output.PrestadoresOutputDTO

interface Atendimento {
    fun obterPrestadoresSaude(latitude: Double, longitude: Double, especialidade : String) : List<PrestadoresOutputDTO>
}