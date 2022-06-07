package com.example.komikamiapp.ui.manhwa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.komikamiapp.R
import com.example.komikamiapp.databinding.FragmentManhwaBinding
import com.example.komikamiapp.network.Manhwa

class ManhwaFragment : Fragment() {

    private val viewModel: ManhwaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentManhwaBinding.inflate(inflater)
        viewModel.getManhwaList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = ManhwaAdapter(ManhwaListener { manhwas ->
            viewModel.onManhwaClicked(manhwas)
            findNavController()
                .navigate(R.id.action_manhwaFragment_to_manhwaDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "MovieKu"

        return binding.root
    }
}