package com.example.todo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.data.entity.ToDo
import com.example.todo.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yrepo: ToDoRepository) : ViewModel() {
    var toDoListesi = MutableLiveData<List<ToDo>>()

    init {
        kisileriYukle()
    }

    fun sil(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.sil(id)
            kisileriYukle()
        }
    }

    fun kisileriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value = yrepo.kisileriYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value = yrepo.ara(aramaKelimesi)
        }
    }
}