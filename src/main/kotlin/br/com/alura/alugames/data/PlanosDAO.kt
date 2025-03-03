package br.com.alura.alugames.data

import PlanoAssinaturaEntity
import PlanoAvulsoEntity
import PlanoEntity
import br.com.alura.alugames.model.Plano
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.model.PlanoAvulso
import br.com.alura.alugames.util.toEntity
import br.com.alura.alugames.util.toModel
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}