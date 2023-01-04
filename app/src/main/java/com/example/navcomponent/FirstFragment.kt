package com.example.navcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navcomponent.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    companion object{
        const val DATA = "DATA"
    }
    private val list = arrayListOf<Character>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.clear()
        loadData()
        val adapter = CharacterAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter

    }

    private fun onClick(position: Int){
        val user = Character(list[position].image, list[position].desc, list[position].name)
        findNavController().navigate(R.id.secondFragment, bundleOf(DATA to user))
    }

    private fun loadData() {
        list.add(Character("https://i.pinimg.com/564x/b3/56/44/b35644024c97c3069f342d708e97fa07.jpg", "alive", "Stella"))
        list.add(Character("https://i.pinimg.com/564x/04/3e/0d/043e0d3f01de2aeeba6d2aa4b0a874a0.jpg", "alive", "Musa"))
        list.add(Character("https://i.pinimg.com/564x/c9/d4/cd/c9d4cd2873dcfa8ac5690c787d8c6364.jpg", "alive", "Aisha"))
        list.add(Character("https://i.pinimg.com/564x/d1/df/90/d1df90671e49673b8b2381533cd957b6.jpg", "dead", "Nabu"))
        list.add(Character("https://i.pinimg.com/564x/35/aa/bd/35aabd3b988258735ce09045035ea4d0.jpg", "alive", "Darcy"))
        list.add(Character("https://i.pinimg.com/564x/4a/3f/06/4a3f0665319ae23711a2db1969560858.jpg", "alive", "Icy"))
        list.add(Character("https://i.pinimg.com/564x/d0/3c/25/d03c25f0e543a88e90cb902ea586ea1b.jpg", "alive", "Stormy"))
        list.add(Character("https://i.pinimg.com/564x/dc/c5/ed/dcc5ed68c090bea213a4023ad3624cc0.jpg", "alive", "Brandon"))
    }
}