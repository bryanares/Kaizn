package com.brian.kaizn.data.repository

import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.utils.Rezults
import kotlinx.coroutines.flow.Flow

class KaiznRepositoryImplementation(): KaiznRepository {
    override suspend fun createNewHabit(newHabit: HabitEntity): Flow<Rezults<HabitEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateExistingHabit(
        habitId: Long?,
        existingHabit: HabitEntity
    ): Flow<Rezults<HabitEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSingleHabit(
        habitId: Long,
        userId: Long
    ): Flow<Rezults<List<HabitEntity>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleHabit(habitId: Long): Flow<Rezults<HabitEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllHabits(userId: Long): Flow<Rezults<List<HabitEntity>>> {
        TODO("Not yet implemented")
    }
}