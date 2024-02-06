package com.mehedi.dogger.common

import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.Owner
import com.mehedi.dogger.database.model.OwnerDogRef

object OneToOneRelation {
    fun getDogList(): List<Dog> {
        return listOf(
            Dog(
                dogOwnerId = 1,
                name = "Dog 1",
                dogId = 1
            ),
            Dog(
                dogOwnerId = 2,
                name = "Dog 2",
                dogId = 2
            ),
            Dog(
                dogOwnerId = 3,
                name = "Dog 3",
                dogId = 3
            ),
            Dog(
                dogOwnerId = 4,
                name = "Dog 4",
                dogId = 4
            ),
            Dog(
                dogOwnerId = 5,
                name = "Dog 5",
                dogId = 5
            ),
        )
    }

    fun getOwnerList(): List<Owner> {
        return listOf(
            Owner(
                ownerId = 1, name = "Owner 1"
            ),
            Owner(
                ownerId = 2, name = "Owner 2"
            ),
            Owner(
                ownerId = 3, name = "Owner 3"
            ),
            Owner(
                ownerId = 4, name = "Owner 4"
            ),
            Owner(
                ownerId = 5, name = "Owner 5"
            ),
        )
    }
}

object OneToManyRelation {
    fun getDogList(): List<Dog> {
        return listOf(
            Dog(
                dogOwnerId = 1,
                name = "Dog 1",
                dogId = 1
            ),
            Dog(
                dogOwnerId = 2,
                name = "Dog 2",
                dogId = 2
            ),
            Dog(
                dogOwnerId = 3,
                name = "Dog 3",
                dogId = 3
            ),
            Dog(
                dogOwnerId = 4,
                name = "Dog 4",
                dogId = 4
            ),
            Dog(
                dogOwnerId = 5,
                name = "Dog 5",
                dogId = 5
            ),
            Dog(
                dogOwnerId = 5,
                name = "Dog 6",
                dogId = 6
            ),
            Dog(
                dogOwnerId = 1,
                name = "Dog 7",
                dogId = 7
            ),
        )
    }

    fun getOwnerList(): List<Owner> {
        return listOf(
            Owner(
                ownerId = 1, name = "Owner 1"
            ),
            Owner(
                ownerId = 2, name = "Owner 2"
            ),
            Owner(
                ownerId = 3, name = "Owner 3"
            ),
            Owner(
                ownerId = 4, name = "Owner 4"
            ),
            Owner(
                ownerId = 5, name = "Owner 5"
            ),
            Owner(
                ownerId = 6, name = "Owner 6"
            ),
        )
    }
}

object ManyToManyRelation {

    fun getList(): List<OwnerDogRef> {

        return listOf(
            OwnerDogRef(1, 1),
            OwnerDogRef(1, 2),
            OwnerDogRef(1, 3),
            OwnerDogRef(2, 4),
            OwnerDogRef(2, 6),
            OwnerDogRef(3, 5),
            OwnerDogRef(4, 6),
        )
    }


}
