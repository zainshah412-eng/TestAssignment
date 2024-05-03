package com.example.testassignment.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listing_data.room.ListingDAO
import com.example.listing_domain.model.University

@Database(entities = [University::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getListing(): ListingDAO
}