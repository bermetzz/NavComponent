package com.example.navcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navcomponent.databinding.ItemCharactersBinding

class CharacterAdapter(
    val characterList: ArrayList<Character>,
    val onClick: (position:Int) -> Unit
): Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = characterList.size

    inner class ViewHolder(private val binding: ItemCharactersBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = characterList[adapterPosition]
            binding.apply {
                characterIv.loadImage(item.image)
                descriptionTv.text = item.desc
                nameTv.text = item.name
            }
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
}