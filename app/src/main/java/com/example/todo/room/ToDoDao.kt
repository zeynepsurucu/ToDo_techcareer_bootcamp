package com.example.todo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDos")
    suspend fun yapilacaklariYukle(): List<ToDo>

    @Insert
    suspend fun kaydet(toDo: ToDo)

    @Update
    suspend fun guncelle(name: ToDo)

    @Delete
    suspend fun sil(toDo: ToDo)

    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi: String): List<ToDo>

}