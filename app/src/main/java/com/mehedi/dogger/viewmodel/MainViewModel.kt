package com.mehedi.dogger.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import com.mehedi.dogger.common.ManyToManyRelation
import com.mehedi.dogger.common.OneToManyRelation
import com.mehedi.dogger.database.DogDao
import com.mehedi.dogger.database.model.OwnerDog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val exampleDao: DogDao) : ViewModel() {

    val list = MutableLiveData<List<OwnerDog>>()

    init {


        viewModelScope.launch(Dispatchers.IO) {

            async {
                exampleDao.insertDog(OneToManyRelation.getDogList())
            }.await()

            async {
                exampleDao.insertOwner(OneToManyRelation.getOwnerList())
            }.await()

            async {
                exampleDao.insertOwnerDog(ManyToManyRelation.getList())
            }.await()


        }
        viewModelScope.launch {
            delay(3000)
            async {
                list.value = exampleDao.getAllOwnerDog()
            }.await()
        }

    }


}