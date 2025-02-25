package br.com.alura.alugames.model

import com.google.gson.annotations.Expose
import formatoComDuasCasasDecimais
import java.math.BigDecimal
import java.math.RoundingMode

data class Jogo(@Expose val titulo: String,
                @Expose val capa: String): Recomendavel {
    var descricao: String? = null
    var preco = BigDecimal("0.0")
    var id = 0
    private var listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String, id: Int = 0): this(titulo, capa) {
        this.preco = BigDecimal(preco).setScale(2, RoundingMode.HALF_EVEN)
        this.descricao = descricao
        this.id = id
    }

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

    override fun toString(): String {
        return "Jogo:\n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media \n" +
                "Id: $id"
    }
}