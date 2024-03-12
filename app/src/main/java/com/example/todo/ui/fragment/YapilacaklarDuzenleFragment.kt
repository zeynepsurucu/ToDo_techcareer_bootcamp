package com.example.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.todo.databinding.FragmentYapilacaklarDuzenleBinding
import com.example.todo.ui.viewmodel.YapilacaklarDuzenleViewModel
import com.example.todo.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacaklarDuzenleFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaklarDuzenleBinding
    private lateinit var viewModel: YapilacaklarDuzenleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacaklarDuzenleBinding.inflate(inflater, container, false)

        val bundle: YapilacaklarDuzenleFragmentArgs by navArgs()
        val gelenToDo = bundle.toDo

        binding.editTextYapilacak.setText(gelenToDo.name)

        binding.buttonDuzenle.setOnClickListener {
            val name = binding.editTextYapilacak.text.toString()
            viewModel.guncelle(gelenToDo.id, name)
            val gecis = YapilacaklarDuzenleFragmentDirections.duzenleAnasayfaGecis()
            Navigation.gecis(it, gecis)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarDuzenleViewModel by viewModels()
        viewModel = tempViewModel
    }
}