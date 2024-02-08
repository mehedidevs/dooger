package com.mehedi.dogger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.OwnerDog
import com.mehedi.dogger.databinding.ItemDogNameBinding
import com.mehedi.dogger.databinding.ItemDogWithOwnerBinding

class DogChildAdapter(val list: List<Dog>, val onDogClicked: OnDogClicked) :
    RecyclerView.Adapter<DogChildAdapter.ChildVH>() {


    interface OnDogClicked {
        fun dogClicked(dog: Dog)
    }

    inner class ChildVH(val binding: ItemDogNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: Dog) {

            binding.apply {
                tvDogName.text = dog.name
                binding.root.setOnClickListener {

                    onDogClicked.dogClicked(dog)

                }


            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildVH {

        return ChildVH(
            ItemDogNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChildVH, position: Int) {
        holder.bind(list[position])
    }

}


