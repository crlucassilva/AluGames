package br.com.alura.alugames.main

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.service.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLast = listaJogos.get(2)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(1))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo4 = Periodo(LocalDate.of(2024,8,1), LocalDate.of(2024,8,15))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLast, periodo3)
    gamerCaroline.alugaJogo(jogoSpider, periodo4)

//    println(gamerCaroline.jogosAlugados)
//    println(gamerCaroline.jogosDoMes(1))

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", BigDecimal("9.90"), 3, BigDecimal("0.15"))

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoTheLast, periodo3)
    gamerCamila.alugaJogo(jogoTheLast, periodo3)

//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)

    println(gamerCamila.media)
    println(gamerCamila.alugaJogo(jogoResidentVillage, periodo1))

    gamerCamila.recomendarJogo(jogoSpider, 11)
    gamerCamila.recomendarJogo(jogoResidentVillage, 7)

    gamerCaroline.recomendarJogo(jogoSpider, 9)
    gamerCaroline.recomendarJogo(jogoResidentVillage, 10)

//    println("---------------------Recomendações da Caroline")
//    println(gamerCaroline.jogosRecomendados)
//    println("---------------------Recomendações da Camila")
//    println(gamerCamila.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCaroline.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCaroline.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}