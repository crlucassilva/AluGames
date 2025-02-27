package br.com.alura.alugames.data

import br.com.alura.alugames.model.Gamer
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return GamerEntity(objeto.nome, objeto.email, objeto.dataNascimento, objeto.usuario, objeto.id)
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)
    }
}