package br.com.alura.alugames.main

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.service.ConsumoApi
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(sc)
    println("Cadastro Concluído com Sucesso! Dados do Gamer:")
    println(gamer)

    do {
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

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? (S/N)")
        val resposta = sc.nextLine()

        } while (resposta.equals("S", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\nJogos ordenados por título: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println("\nJogos Filtrados:")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? (S/N)")
    val opcao = sc.nextLine()
    if(opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao = sc.nextInt();
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\nLista atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso!")
}