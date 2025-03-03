package br.com.alura.alugames.data

import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.util.toEntity
import br.com.alura.alugames.util.toModel
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {
    override fun toEntity(objeto: Jogo): JogoEntity{
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }
}