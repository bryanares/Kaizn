package com.brian.kaizn.data.local.dao

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface KaiznDao {

    @Insert
    suspend fun Insert()
}