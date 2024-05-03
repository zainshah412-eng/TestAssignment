package com.example.listing_data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listing_domain.model.University

@Dao
interface ListingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<University>)

    @Query("SELECT * FROM UNIVERSITY")
    suspend fun getAllListing(): List<University>
}