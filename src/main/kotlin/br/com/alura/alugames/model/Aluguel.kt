package br.com.alura.alugames.model

import java.math.RoundingMode

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorDoAluguel = gamer.plano.obterValor(this).setScale(2, RoundingMode.HALF_EVEN)
    var id = 0

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor $valorDoAluguel"
    }
}
