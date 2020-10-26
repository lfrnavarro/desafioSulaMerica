package desafio.controllers

import desafio.input.Atendimento
import desafio.output.PrestadoresOutputDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/atendimento")
class AtendimentoController(
    val atendimento : Atendimento
){

    @GetMapping("/obterPrestadoresSaude")
    fun obterPrestadoresSaude(@RequestParam latitude: Double, @RequestParam longitude: Double, @RequestParam especialidade : String) : ResponseEntity<List<PrestadoresOutputDTO>> {
        try {
            return ResponseEntity.ok(atendimento.obterPrestadoresSaude(latitude, longitude, especialidade))
        } catch (e: Exception){
            throw e
        }

    }
}