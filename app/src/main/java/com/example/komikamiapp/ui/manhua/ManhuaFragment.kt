package com.example.komikamiapp.ui.manhua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.komikamiapp.R
import com.example.komikamiapp.databinding.FragmentManhuaBinding
import com.example.komikamiapp.ui.manhua.ManhuaAdapter
import com.example.komikamiapp.ui.manhua.ManhuaListener

class ManhuaFragment : Fragment() {

    private val viewModel: ManhuaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentManhuaBinding.inflate(inflater)
        viewModel.getManhuaList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = ManhuaAdapter(ManhuaListener { manhua ->
            viewModel.onManhuaClicked(manhua)
            findNavController()
                .navigate(R.id.action_manhuaFragment_to_manhuaDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "ManhuaKu"

        return binding.root
    }
}