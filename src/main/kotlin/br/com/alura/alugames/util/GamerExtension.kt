package br.com.alura.alugames.util

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}