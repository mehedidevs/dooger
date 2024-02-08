package com.mehedi.dogger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.OwnerDog
import com.mehedi.dogger.databinding.ItemDogNameBinding
import com.mehedi.dogger.databinding.ItemDogWithOwnerBinding

class MainAdapter(
    val list: List<OwnerDog>,
    val onItemClicked: OnItemClicked,
    val onDogClicked: DogChildAdapter.OnDogClicked
) :
    RecyclerView.Adapter<MainAdapter.MainVH>() {

    interface OnItemClicked {
        fun itemClicked(ownerDog: OwnerDog)
    }


    inner class MainVH(val binding: ItemDogWithOwnerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ownerDog: OwnerDog) {

            binding.apply {
                tvName.text = ownerDog.owner.name
                rvChild.adapter =
                    ownerDog.dogs?.let { DogChildAdapter(list = it, onDogClicked = onDogClicked) }

                root.setOnClickListener {

                    onItemClicked.itemClicked(ownerDog)
                }


            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {

        return MainVH(
            ItemDogWithOwnerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(list[position])
    }

}


