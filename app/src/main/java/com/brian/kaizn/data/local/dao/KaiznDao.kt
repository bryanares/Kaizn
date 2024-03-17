package com.brian.kaizn.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.brian.kaizn.data.local.model.entity.HabitEntity

@Dao
interface KaiznDao {

    //create new habit
    @Insert
    suspend fun insertNewHabit(newHabit: HabitEntity)

    //update existing habit
    @Update
    suspend fun updateExistingHabit(exixstingHabit : HabitEntity)

    //delete existing habit
    @Delete
    suspend fun delete(habit: HabitEntity)

    //delete multiple habits
    @Delete
    suspend fun deleteSelectedHabits()

    //get single habit
    @Query("SELECT * FROM HabitEntity WHERE habitId = habitId")
    suspend fun getSingleHabit(
        habitId: Long
    ) : HabitEntity

    //get all habits
    @Query("SELECT * FROM HabitEntity ORDER BY habitCreatedDate DESC")
    suspend fun getAllHabits() : List<HabitEntity>


}