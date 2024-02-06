package com.mehedi.dogger.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.Owner
import com.mehedi.dogger.database.model.OwnerDog
import com.mehedi.dogger.database.model.OwnerDogRef


@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: List<Owner>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: List<Dog>)

    @Query("SELECT * FROM Owner")
    suspend fun getAllOwner(): List<Owner>

    @Query("SELECT * FROM Dog")
    suspend fun getAllDog(): List<Dog>

    @Transaction
    @Query("SELECT * FROM Owner")
    suspend fun getAllOwnerDog(): List<OwnerDog>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwnerDog(dog: List<OwnerDogRef>)


}