package br.com.chckpoint_infinity_3sir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.chckpoint_infinity_3sir.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(), ItemAdapter.OnFilmeClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItem: RecyclerView = findViewById(R.id.rvItem)
        val fabAdd: FloatingActionButton = findViewById(R.id.fabAdd)

        fabAdd.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        rvItem.layoutManager = LinearLayoutManager(this)
        rvItem.adapter = ItemAdapter(Database.listaFilmes,this  )

    }

    override fun onFilmeClick(filmePosition: Int) {
        val intent = Intent(this, VisualizarActivity::class.java)
        intent.putExtra("dados", Database.listaFilmes[filmePosition])
        startActivity(intent)
    }
}