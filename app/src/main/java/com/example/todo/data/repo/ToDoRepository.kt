package com.example.todo.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.todo.data.datasource.ToDoDataSource
import com.example.todo.data.entity.ToDo

class ToDoRepository(var yds: ToDoDataSource) {

    suspend fun kaydet(name: String) = yds.kaydet(name)

    suspend fun guncelle(id: Int, name: String) = yds.guncelle(id, name)

    suspend fun sil(id: Int) = yds.sil(id)

    suspend fun kisileriYukle(): List<ToDo> = yds.yapilacaklarYukle()

    suspend fun ara(aramaKelimesi: String): List<ToDo> = yds.ara(aramaKelimesi)
}