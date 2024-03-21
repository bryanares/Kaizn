package com.brian.kaizn.data.repository

import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.utils.Rezults

interface KaiznRepository {

    //create new habit
    ///what do I expect as return? Flow<sealed class>
    //I want to return a list of instances of HabitEntryWithGoal
    suspend fun createNewHabit(newHabit: HabitWithGoalEntity): Rezults<List<HabitWithGoalEntity>>

    //update
    //I want to return an instance of HabitEntryWithGoal but don't understand what it requires
    suspend fun updateExistingHabit(
        habitId: Long,
        existingHabit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>>

    //delete habit
    suspend fun deleteSingleHabit(
        habitId: Long,
        habit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>>

    //get single habit
    suspend fun getSingleHabit(
        habitId: Long,
        selectedHabit: HabitWithGoalEntity
    ): Rezults<HabitWithGoalEntity>

    //get list of habits
    suspend fun getAllHabits(
        userId: Long,
        selectedHabit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>>
}