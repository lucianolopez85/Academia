package com.example.academia.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academia.Model.Categoria
import com.example.academia.Model.Treino
import com.example.academia.R
import com.example.academia.databinding.ActivityMainBinding.inflate
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.semana_item.*
import kotlinx.android.synthetic.main.semana_item.view.*
import kotlinx.android.synthetic.main.treino_item.view.*

class Home : Fragment() {

    private lateinit var categoriaAdapter: CategoriaAdapter

    companion object {
        fun newInstance(): Home {
            val fragmentHome = Home()
            val argumentos = Bundle()
            fragmentHome.arguments = argumentos
            return fragmentHome

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val categorias: MutableList<Categoria> = ArrayList()
        for(c in 1..5){
            val categoria = Categoria()
            categoria.titulo = "$c° Dia"

            val treinos: MutableList<Treino> = ArrayList()
            for (a in 0..5){
                val treino = Treino()
                treino.treino = R.drawable.img_treino
                treinos.add(treino)
            }
            categoria.treinos = treinos
            categorias.add(categoria)
        }


        categoriaAdapter = CategoriaAdapter(categorias)
        recycler_view_home_treino.adapter = categoriaAdapter
        recycler_view_home_treino.layoutManager = LinearLayoutManager(context)


    }

    private inner class CategoriaAdapter(private val categorias: MutableList<Categoria>): RecyclerView.Adapter<CategoriaHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
            return CategoriaHolder(layoutInflater.inflate(R.layout.semana_item, parent, false))
        }

        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
            val categoria = categorias[position]
            holder.bind(categoria)
        }

        override fun getItemCount(): Int = categorias.size
    }


    private inner class CategoriaHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(categoria: Categoria){
            itemView.text_titulo_dia_semana.text = categoria.titulo
            itemView.recycler_view_listagem_horizontal_treinos.adapter = TreinosAdapter(categoria.treinos)
            itemView.recycler_view_listagem_horizontal_treinos.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

    }
//==================== Treino - lista horizontal ===========================

    private inner class TreinosAdapter(private val treinos: MutableList<Treino>): RecyclerView.Adapter<TreinosHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinosHolder {
            return TreinosHolder(layoutInflater.inflate(R.layout.treino_item, parent, false))

        }

        override fun onBindViewHolder(holder: TreinosHolder, position: Int) {
            val treino = treinos[position]
            holder.bind(treino)
        }

        override fun getItemCount(): Int = treinos.size
    }

    private inner class TreinosHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(treino: Treino){
            itemView.img_treino.setImageResource(treino.treino)
        }
    }
}