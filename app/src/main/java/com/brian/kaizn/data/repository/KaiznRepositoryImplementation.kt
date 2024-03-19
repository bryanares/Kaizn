package com.brian.kaizn.data.repository

import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.utils.Rezults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KaiznRepositoryImplementation @Inject constructor (kaiznDao: KaiznDao): KaiznRepository {
    override suspend fun createNewHabit(newHabit: HabitEntity): Rezults<HabitEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun updateExistingHabit(
        habitId: Long?,
        existingHabit: HabitEntity
    ): Rezults<HabitEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSingleHabit(
        habitId: Long,
        userId: Long
    ): Rezults<List<HabitEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleHabit(habitId: Long): Rezults<HabitEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllHabits(userId: Long): Rezults<List<HabitEntity>> {
        TODO("Not yet implemented")
    }
}