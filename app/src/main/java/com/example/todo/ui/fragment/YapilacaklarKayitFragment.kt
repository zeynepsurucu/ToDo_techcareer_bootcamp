package com.example.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todo.R
import com.example.todo.databinding.FragmentYapilacaklarKayitBinding
import com.example.todo.ui.viewmodel.YapilacaklarKayitViewModel
import com.example.todo.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacaklarKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaklarKayitBinding
    private lateinit var viewModel: YapilacaklarKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacaklarKayitBinding.inflate(inflater, container, false)

        binding.buttonEkle.setOnClickListener {
            val name = binding.editTextToDo.text.toString()
            viewModel.kaydet(name)
            val gecis = YapilacaklarKayitFragmentDirections.anasayfaGecis()
            Navigation.gecis(it, gecis)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarKayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}