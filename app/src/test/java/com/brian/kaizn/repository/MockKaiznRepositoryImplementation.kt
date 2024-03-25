package com.brian.kaizn.repository

import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitGoalEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.repository.KaiznRepository
import com.brian.kaizn.data.repository.ReturnNothing
import com.brian.kaizn.data.utils.Rezults

class MockKaiznRepositoryImplementation : KaiznRepository {
    override suspend fun createNewHabit(newHabit: HabitEntity): Rezults<Long> {
        return Rezults.Success(777)
    }

    override suspend fun updateExistingHabit(existingHabit: HabitEntity): Rezults<ReturnNothing> {
        return Rezults.Success(ReturnNothing())
    }

    override suspend fun deleteSingleHabit(habit: HabitEntity): Rezults<ReturnNothing> {
        return Rezults.Success(ReturnNothing())
    }

    override suspend fun getSingleHabit(habitId: Long): Rezults<HabitWithGoalEntity> {
        return Rezults.Success(HabitWithGoalEntity(HabitEntity(), HabitGoalEntity()))
    }

    override suspend fun getAllHabits(): Rezults<List<HabitWithGoalEntity>> {
        return Rezults.Success(listOf(HabitWithGoalEntity(HabitEntity(), HabitGoalEntity())))
    }
}