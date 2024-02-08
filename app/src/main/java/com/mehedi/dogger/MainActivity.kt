package com.mehedi.dogger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.OwnerDog
import com.mehedi.dogger.databinding.ActivityMainBinding
import com.mehedi.dogger.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainAdapter.OnItemClicked, DogChildAdapter.OnDogClicked {
    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.list.observe(this) {

            binding.rvDogOwner.adapter = MainAdapter(it, this, this)

        }

    }

    override fun dogClicked(dog: Dog) {
        Toast.makeText(this, dog.name, Toast.LENGTH_LONG).show()
    }

    override fun itemClicked(ownerDog: OwnerDog) {
        Toast.makeText(this, ownerDog.owner.name, Toast.LENGTH_LONG).show()
    }
}