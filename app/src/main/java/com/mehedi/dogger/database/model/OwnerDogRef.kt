package com.mehedi.dogger.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.Owner

@Entity(
    primaryKeys = ["ownerId", "dogId"],
    foreignKeys = [
        ForeignKey(
            entity = Owner::class,
            parentColumns = ["ownerId"],
            childColumns = ["ownerId"],
        ),
        ForeignKey(
            entity = Dog::class,
            parentColumns = ["dogId"],
            childColumns = ["dogId"],
        ),

    ]

)
data class OwnerDogRef(
    val ownerId: Int,
    val dogId: Int

)
