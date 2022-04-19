package br.com.chckpoint_infinity_3sir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.chckpoint_infinity_3sir.R
import br.com.chckpoint_infinity_3sir.model.Filme

class ItemAdapter(val dataSet: List<Filme>, val onFilmeClickListener: OnFilmeClickListener ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View,  val onFilmeClickListener: OnFilmeClickListener):RecyclerView.ViewHolder(view), View.OnClickListener{
        val tvItemNome: TextView = view.findViewById(R.id.tvItemNome)
        val tvItemPreco: TextView = view.findViewById(R.id.tvItemPreco)
        val tvItemProdutora: TextView = view.findViewById(R.id.tvItemProdutora)
        val cvItemLista: CardView = view.findViewById(R.id.cvItemLista)

        init {
            cvItemLista.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onFilmeClickListener.onFilmeClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return ItemViewHolder(adapterLayout, onFilmeClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val filme = dataSet[position]
        holder.tvItemNome.text = filme.nome
        holder.tvItemPreco.text = filme.preco.toString()
        holder.tvItemProdutora.text = filme.produtora
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    interface OnFilmeClickListener{
        fun onFilmeClick(filmePosition: Int)
    }

}