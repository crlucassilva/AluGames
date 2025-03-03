package br.com.alura.alugames.util

import PlanoAssinaturaEntity
import PlanoAvulsoEntity
import PlanoEntity
import br.com.alura.alugames.model.Plano
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.model.PlanoAvulso
import java.math.BigDecimal
import java.math.RoundingMode

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade.toDouble(), this.jogosIncluidos, this.percentualDescontoReputacao.toDouble(), this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, BigDecimal(this.mensalidade).setScale(2, RoundingMode.HALF_EVEN), this.jogosIncluidos, BigDecimal(this.percentualDescontoReputacao).setScale(2, RoundingMode.HALF_EVEN), this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}