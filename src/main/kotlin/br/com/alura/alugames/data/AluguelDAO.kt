package br.com.alura.alugames.data

import br.com.alura.alugames.model.Aluguel
import br.com.alura.alugames.util.toEntity
import br.com.alura.alugames.util.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply { valorAluguel = objeto.valorDoAluguel.toDouble()
            id = objeto.id }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id }
    }
}