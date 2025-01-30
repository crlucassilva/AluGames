package br.com.alura.alugames.main

import br.com.alura.alugames.service.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("100")
    println(listaGamers)
    println(jogoApi)
}