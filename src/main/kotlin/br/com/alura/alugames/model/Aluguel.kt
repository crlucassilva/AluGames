package br.com.alura.alugames.model

import formatoComDuasCasasDecimais
import java.math.RoundingMode

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorDoAluguel = gamer.plano.obterValor(this).setScale(2, RoundingMode.HALF_EVEN)

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor $valorDoAluguel"
    }
}
