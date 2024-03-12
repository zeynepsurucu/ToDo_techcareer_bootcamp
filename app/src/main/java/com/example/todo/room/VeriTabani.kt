package com.example.todo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun getYapilacaklarDao(): ToDoDao
}