package br.com.alura.alugames.main

import br.com.alura.alugames.data.Banco
import br.com.alura.alugames.data.GamersDAO
import br.com.alura.alugames.data.JogosDAO
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.Jogo

fun main() {

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")
    val gamer = Gamer("Lucas", "lucas@gmail.com", "12/04/1996", "crlucas")


    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
//    jogoDAO.adicionar(jogo2)

//    val jogoRecuperado = jogoDAO.recuperarPeloId(5)
//    println(jogoRecuperado)

//    jogoDAO.apagar(5)

    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    val gamersDao = GamersDAO(manager)
//    gamerDao.adicionaGamer(gamer)

//    val gamerRecuperado = gamerDao.recuperarPeloId(2)
//    println(2)

//    gamerDao.apagar(2)

    val listaGamer: List<Gamer> = gamersDao.getLista()
    println(listaGamer)

    manager.close()
}