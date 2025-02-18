package br.com.alura.alugames.model

data class Jogo(val titulo: String,
                val capa: String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    var listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String): this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            print("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

    override fun toString(): String {
        return "Jogo:\n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco"
    }
}