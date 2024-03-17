package com.brian.kaizn.data.repository

import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.utils.Rezults
import kotlinx.coroutines.flow.Flow

interface KaiznRepository {

    //create new habit
    ///what do I expect as return? Flow<sealed class>
    suspend fun createNewHabit(newHabit : HabitEntity): Flow<Rezults<HabitEntity>>

    //update
    suspend fun updateExistingHabit (habitId: Long?, existingHabit : HabitEntity): Flow<Rezults<HabitEntity>>

    //delete habit
    suspend fun deleteSingleHabit(habitId: Long, userId: Long): Flow<Rezults<List<HabitEntity>>>

    //get single habit
    suspend fun getSingleHabit(habitId: Long): Flow<Rezults<HabitEntity>>

    //get list of habits
    suspend fun getAllHabits(userId: Long): Flow<Rezults<List<HabitEntity>>>
}