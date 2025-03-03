package br.com.alura.alugames.data

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.util.toEntity
import br.com.alura.alugames.util.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}