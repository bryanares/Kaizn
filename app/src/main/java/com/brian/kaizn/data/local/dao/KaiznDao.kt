package com.brian.kaizn.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.utils.Rezults

@Dao
interface KaiznDao {

    //create new habit
    //edited return to HabitWithGoalEntity
    @Insert
    suspend fun insertNewHabit(newHabit: HabitWithGoalEntity): List<HabitWithGoalEntity>

    //update existing habit
    @Update
    suspend fun updateExistingHabit(
        habitId: Long,
        existingHabit: HabitWithGoalEntity
    ): List<HabitWithGoalEntity>

    //delete existing habit
    @Delete
    suspend fun deleteHabit(habitId: Long, habit: HabitWithGoalEntity): List<HabitWithGoalEntity>

    //delete multiple habits
    @Delete
    suspend fun deleteSelectedHabits()

    //get single habit
    @Query("SELECT * FROM HabitEntity WHERE habitId = habitId")
    suspend fun getSingleHabit(
        habitId: Long
    ): HabitEntity

    //get all habits
    @Query("SELECT * FROM HabitEntity ORDER BY habitCreatedDate DESC")
    suspend fun getAllHabits(): List<HabitWithGoalEntity>

    //get goal with habit
    //is the query correct?
    @Transaction
    @Query("SELECT * FROM HabitEntity WHERE habitId = :habitEntityId")
    suspend fun getHabitWithGoal(habitEntityId: Long): List<HabitWithGoalEntity>? = null

}