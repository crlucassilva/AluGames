package br.com.alura.alugames.main

import br.com.alura.alugames.data.Banco
import br.com.alura.alugames.data.JogosDAO
import br.com.alura.alugames.model.Jogo

fun main() {

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogoDAO = JogosDAO()
    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)
}