package br.com.alura.alugames.main

import br.com.alura.alugames.data.Banco
import br.com.alura.alugames.data.GamersDAO
import br.com.alura.alugames.data.PlanosDAO
import br.com.alura.alugames.model.Gamer

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamersDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(3)

    gamersDAO.adicionar(gamer)

    val listaGamersBanco = gamersDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}