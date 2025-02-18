package br.com.alura.alugames.model

import formatoComDuasCasasDecimais

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorDoAluguel = gamer.plano.obterValor(this).formatoComDuasCasasDecimais()

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor $valorDoAluguel"
    }
}
