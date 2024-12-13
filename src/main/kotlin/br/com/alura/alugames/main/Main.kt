package br.com.alura.alugames.main

import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.service.ConsumoApi
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = sc.nextLine()

    val buscaApi = ConsumoApi()

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val meuInfoJogo = buscaApi.buscaJogo(busca)
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? (S/N)")
        val opcao = sc.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição perzonalizada para o jogo:")
            val descricaoPersonalizada = sc.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
        resultado.onSuccess {
            println("Busca finalizada com sucesso!")
        }
    }
}