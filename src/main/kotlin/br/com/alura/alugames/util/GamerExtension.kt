package br.com.alura.alugames.util

import br.com.alura.alugames.data.GamerEntity
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.nome, this.email, this.dataNascimento, this.usuario, this.id, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}