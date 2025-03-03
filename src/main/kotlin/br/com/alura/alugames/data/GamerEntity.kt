package br.com.alura.alugames.data

import PlanoAvulsoEntity
import PlanoEntity
import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity(
    val nome: String = "Nome do Gamer",
    val email: String = "Email do Gamer",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()) {
}