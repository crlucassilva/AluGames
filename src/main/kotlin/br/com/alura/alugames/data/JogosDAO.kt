package br.com.alura.alugames.data

import br.com.alura.alugames.model.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao()

        if (conexao != null) {
            try {
                val st = conexao.createStatement()
                val rs = st.executeQuery("SELECT * FROM JOGOS")

                while (rs.next()) {
                    val id = rs.getInt("id")
                    val titulo = rs.getString("titulo")
                    val capa = rs.getString("capa")
                    val descricao = rs.getString("descricao")
                    val preco = rs.getDouble("preco")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    listaJogos.add(jogo)
                }
                st.close()
            } finally {
                conexao.close()

            }
        }
        return listaJogos
    }

    fun adicionarJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao()
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if (conexao != null) {
            try {
                val st = conexao.prepareStatement(insert)
                st.setString(1, jogo.titulo)
                st.setString(2, jogo.capa)
                st.setDouble(3, jogo.preco.toDouble())
                st.setString(4, jogo.descricao)

                st.executeUpdate()
                st.close()
            } finally {
                conexao.close()
            }
        }
    }
}