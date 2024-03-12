package com.example.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.R
import com.example.todo.databinding.FragmentAnasayfaBinding
import com.example.todo.ui.adapter.ToDoAdapter
import com.example.todo.ui.viewmodel.AnasayfaViewModel
import com.example.todo.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment()  {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.toDoListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = ToDoAdapter(requireContext(),it,viewModel)
            binding.kisilerRv.adapter = kisilerAdapter
        }

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.kayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText)
                return true
        }

            override fun onQueryTextSubmit(query: String): Boolean {//Klavyedeki ara buttonu ile çalışır
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }
}