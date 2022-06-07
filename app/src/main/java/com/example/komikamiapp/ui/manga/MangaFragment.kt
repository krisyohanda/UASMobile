package com.example.komikamiapp.ui.manga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.komikamiapp.R
import com.example.komikamiapp.databinding.FragmentMangaBinding

class MangaFragment : Fragment() {

    private val viewModel: MangaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMangaBinding.inflate(inflater)
        viewModel.getMangaList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MangaAdapter(MangaListener { manga ->
            viewModel.onMangaClicked(manga)
            findNavController()
                .navigate(R.id.action_mangaFragment_to_mangaDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "MangaKu"

        return binding.root
    }
}