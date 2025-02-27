package br.com.alura.alugames.data

import br.com.alura.alugames.model.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {
    override fun toEntity(objeto: Jogo): JogoEntity{
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco.toDouble(), objeto.descricao, objeto.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }
}