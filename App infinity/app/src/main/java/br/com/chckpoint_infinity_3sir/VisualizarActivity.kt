package br.com.chckpoint_infinity_3sir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.chckpoint_infinity_3sir.model.Filme

class VisualizarActivity : AppCompatActivity() {

    private lateinit var filmeSelecionado:Filme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        filmeSelecionado = intent.getSerializableExtra("dados") as Filme

        val tvNome: TextView = findViewById(R.id.tvNome)
        val tvPreco: TextView = findViewById(R.id.tvPreco)
        val tvId: TextView = findViewById(R.id.tvId )
        val tvProdutora: TextView = findViewById(R.id.tvProdutora)
        val tvDescricao: TextView = findViewById(R.id.tvDescricao)

        tvNome.text = filmeSelecionado.nome
        tvPreco.text = filmeSelecionado.preco.toString()
        tvId.text = filmeSelecionado.idFilme.toString()
        tvProdutora.text = filmeSelecionado.produtora
        tvDescricao.text = filmeSelecionado.descricao
    }
}