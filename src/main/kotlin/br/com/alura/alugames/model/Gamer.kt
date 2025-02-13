package br.com.alura.alugames.model

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    var plano: Plano = PlanoAvulso("BRONZE")

    constructor(nome: String, email: String, dataNascimento:String, usuario:String): this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    init {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
        email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel -> aluguel.periodo.dataInicial.monthValue == mes }
            .map { aluguel -> aluguel.jogo }
    }

    companion object {
        fun criarGamer(sc: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = sc.nextLine()
            println("Digite seu e-mail:")
            val email = sc.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = sc.nextLine()

            if (opcao.equals("S", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = sc.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = sc.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }
}


