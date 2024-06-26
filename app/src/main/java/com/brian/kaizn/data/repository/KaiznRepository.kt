package com.brian.kaizn.data.repository

import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.local.model.entity.UserEntity
import com.brian.kaizn.data.utils.Rezults
import kotlinx.coroutines.flow.Flow

interface KaiznRepository {

    //signup and signin
    suspend fun signIn(email: String, password: String): Flow<Rezults<UserEntity>>

    suspend fun signUp(email: String, password: String, name: String): Flow<Rezults<UserEntity>>
    //create new habit
    ///what do I expect as return? Flow<sealed class>
    //I want to return a list of instances of HabitEntryWithGoal
    suspend fun createNewHabit(newHabit: HabitEntity): Rezults<Long>

    //update
    //I want to return an instance of HabitEntryWithGoal but don't understand what it requires
    suspend fun updateExistingHabit(
        existingHabit: HabitEntity
    ): Rezults<ReturnNothing>

    //delete habit
    suspend fun deleteSingleHabit(
        habit: HabitEntity
    ): Rezults<ReturnNothing>

    //get single habit
    suspend fun getSingleHabit(
        habitId: Long
    ): Rezults<HabitWithGoalEntity>

    //get list of habits
    suspend fun getAllHabits(
    ): Rezults<List<HabitWithGoalEntity>>
}