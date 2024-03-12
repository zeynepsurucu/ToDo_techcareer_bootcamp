package com.example.todo.di

import android.content.Context
import androidx.room.Room
import com.example.todo.data.datasource.ToDoDataSource
import com.example.todo.data.repo.ToDoRepository
import com.example.todo.room.ToDoDao
import com.example.todo.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(yds: ToDoDataSource): ToDoRepository {
        return ToDoRepository(yds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(ydao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): ToDoDao {
        val vt = Room.databaseBuilder(context, VeriTabani::class.java, "yapilacaklar.sqlite")
            .createFromAsset("yapilacaklar.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}