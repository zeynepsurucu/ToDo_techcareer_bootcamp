package com.example.todo.data.datasource

import com.example.todo.data.entity.ToDo
import com.example.todo.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var ydao: ToDoDao) {
    suspend fun yapilacaklarYukle(): List<ToDo> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.yapilacaklariYukle()
        }

    suspend fun kaydet(name: String) {
        val yeniKisi = ToDo(0, name)
        ydao.kaydet(yeniKisi)
    }

    suspend fun guncelle(id: Int, name: String) {
        val guncellenenKisi = ToDo(id, name)
        ydao.guncelle(guncellenenKisi)
    }

    suspend fun sil(id: Int) {
        val silinenKisi = ToDo(id, "")
        ydao.sil(silinenKisi)
    }

    suspend fun ara(aramaKelimesi: String): List<ToDo> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.ara(aramaKelimesi)
        }
}