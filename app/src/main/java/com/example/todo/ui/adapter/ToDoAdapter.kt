package com.example.todo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.entity.ToDo
import com.example.todo.databinding.CardTasarimBinding
import com.example.todo.ui.fragment.AnasayfaFragmentDirections
import com.example.todo.ui.viewmodel.AnasayfaViewModel
import com.example.todo.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(
    var mContext: Context,
    var toDoListesi: List<ToDo>,
    var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<ToDoAdapter.CardViewHolder>() {
    inner class CardViewHolder(var tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {//0,1,2
        val toDo = toDoListesi.get(position)
        val t = holder.tasarim
        t.textViewYapilacak.text = toDo.name

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.duzenleGecis(toDo = toDo)
            Navigation.gecis(it, gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${toDo.name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.sil(toDo.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDoListesi.size
    }
}