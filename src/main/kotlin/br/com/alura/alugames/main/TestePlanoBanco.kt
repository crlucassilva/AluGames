package br.com.alura.alugames.main

import br.com.alura.alugames.data.Banco
import br.com.alura.alugames.data.PlanosDAO

fun main() {
//    val avulso = PlanoAvulso("Bronze")
//    val prata = PlanoAssinatura("PRATA", BigDecimal(9.90), 3, BigDecimal(0.15))
//    val ouro = PlanoAssinatura("OURO", BigDecimal(19.90), 6, BigDecimal(0.20))
//    val platina = PlanoAssinatura("PLATINA", BigDecimal(29.90), 9, BigDecimal(0.30))
//    val diamante = PlanoAssinatura("DIAMANTE", BigDecimal(49.90), 15, BigDecimal(0.50))

    val manager = Banco.getEntityManager()
    val planosDAO = PlanosDAO(manager)

//    planosDAO.adicionar(avulso)
//    planosDAO.adicionar(prata)
//    planosDAO.adicionar(ouro)
//    planosDAO.adicionar(platina)
//    planosDAO.adicionar(diamante)

    val listaPlanos = planosDAO.getLista()
    println(listaPlanos)

    manager.close()
}