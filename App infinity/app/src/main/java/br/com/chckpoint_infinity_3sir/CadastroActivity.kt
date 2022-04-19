package br.com.chckpoint_infinity_3sir

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.chckpoint_infinity_3sir.model.Filme

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val etId: EditText = findViewById(R.id.etId)
        val etNome: EditText = findViewById(R.id.etNome)
        val etPreco: EditText = findViewById(R.id.etPreco)
        val etProdutora: EditText = findViewById(R.id.etProdutora)
        val etDescricao: EditText = findViewById(R.id.etDescricao)

        val btAdicionar: Button = findViewById(R.id.btSomar)



        btAdicionar.setOnClickListener {
            cadastrarFilme(etId.text.toString(),etNome.text.toString(), etPreco.text.toString(), etProdutora.text.toString(), etDescricao.text.toString())
            esconderTeclado()
            etNome.text.clear()
            etPreco.text.clear()
            etId.text.clear()
            etDescricao.text.clear()
            etProdutora.text.clear()
            navegar()
        }
    }

    fun cadastrarFilme(idFilme: String, nome: String, preco: String, produtora: String, descricao: String) {
        Database.listaFilmes.add(Filme(idFilme = idFilme.toInt(), nome = nome, preco = preco.toDouble(), produtora = produtora, descricao = descricao ))
    }

    fun esconderTeclado() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view: View? = currentFocus
        imm.hideSoftInputFromWindow (view?.windowToken, 0)
    }

    fun navegar(){
        val intent = Intent(this, ListaActivity::class.java)
        startActivity(intent)
    }

}
