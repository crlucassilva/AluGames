import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer("Jacque", "jacque@gmail.com")
    println(gamer1)

    val gamer2 = Gamer("Jani","jeni@gmail.com", "19/19/1992", "jeniblo")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "19/12/1992"
        it.usuario = "jaqueskywalker"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
}