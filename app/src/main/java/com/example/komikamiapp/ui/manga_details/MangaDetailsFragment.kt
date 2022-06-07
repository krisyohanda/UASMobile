package com.example.komikamiapp.ui.manga_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.komikamiapp.R
import com.example.komikamiapp.databinding.MangaFragmentDetailsBinding
import com.example.komikamiapp.ui.manga.MangaViewModel

class MangaDetailsFragment : Fragment() {

    private val viewModel : MangaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val binding = MangaFragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.manga.value?.title
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_mangaDetailFragment_to_mangaFragment)
        }
        return true
    }
}