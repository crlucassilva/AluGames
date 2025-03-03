package br.com.alura.alugames.main

import br.com.alura.alugames.data.AluguelDAO
import br.com.alura.alugames.data.Banco
import br.com.alura.alugames.data.GamersDAO
import br.com.alura.alugames.data.JogosDAO
import br.com.alura.alugames.model.Periodo

fun main () {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(3)
    val jogo = jogoDAO.recuperarPeloId(4)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}