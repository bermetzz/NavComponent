package com.example.navcomponent

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.navcomponent.databinding.FragmentFirstBinding
import com.example.navcomponent.databinding.ItemCharactersBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    companion object{
        const val DATA = "DATA"
    }
    private val list = arrayListOf<Character>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = CharacterAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter

    }

    private fun onClick(position: Int){
        val user = Character(list[position].image, list[position].desc, list[position].name)
        findNavController().navigate(R.id.secondFragment, bundleOf(DATA to user))
    }

    private fun loadData() {
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Stella"))
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Musa"))
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Aisha"))
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Bloom"))
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Darcy"))
        list.add(Character("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Hello_Web_Series_%28Wordmark%29_Logo.png/1200px-Hello_Web_Series_%28Wordmark%29_Logo.png", "alive", "Icy"))
        list.add(Character("https://static.wikia.nocookie.net/winx-club-it/images/8/88/Stormy_in_615.jpg/revision/latest?cb=20160203135133&path-prefix=it", "alive", "Stormy"))
    }
}