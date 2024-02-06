package com.mehedi.dogger.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mehedi.dogger.database.model.Dog
import com.mehedi.dogger.database.model.Owner
import com.mehedi.dogger.database.model.OwnerDogRef

@Database(
    entities = [Dog::class, Owner::class, OwnerDogRef::class],
    version = 1,
    exportSchema = false
)
abstract class DogDatabase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): DogDatabase {
            return Room.databaseBuilder(context, DogDatabase::class.java, "db_example")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun getExampleDao(): DogDao

}