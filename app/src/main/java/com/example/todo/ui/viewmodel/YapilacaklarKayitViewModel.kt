package com.example.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todo.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacaklarKayitViewModel @Inject constructor(var yrepo:ToDoRepository): ViewModel() {

    fun kaydet(name:String){
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.kaydet(name)
        }
    }
}