package com.brian.kaizn.data.repository

import android.util.Log
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.utils.Rezults
import javax.inject.Inject

class KaiznRepositoryImplementation @Inject constructor(private val kaiznDao: KaiznDao) :
    KaiznRepository {
    override suspend fun createNewHabit(newHabit: HabitWithGoalEntity): Rezults<List<HabitWithGoalEntity>> {
        try {
            kaiznDao.insertNewHabit(newHabit)

        } catch (e: Error) {
            Log.d("Repo", e.message.toString())
        }
        //return Rezults.Success(listOf(HabitWithGoalEntity(habitEntity = newHabit, habitGoalEntity = newHabitWith)))
        return Rezults.Success(listOf(newHabit))
    }

    override suspend fun updateExistingHabit(
        habitId: Long,
        existingHabit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>> {
        try {
            kaiznDao.updateExistingHabit(habitId, existingHabit)
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
        }
        //return Rezults.Success(List<HabitWithGoalEntity>())
        return Rezults.Success(listOf(existingHabit))
    }

    override suspend fun deleteSingleHabit(
        habitId: Long,
        habit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>> {
        try {
            kaiznDao.deleteHabit(habitId, habit)
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
        }
        return Rezults.Success(listOf(habit))
    }

    override suspend fun getSingleHabit(
        habitId: Long,
        selectedHabit: HabitWithGoalEntity
    ): Rezults<HabitWithGoalEntity> {
        try {
            kaiznDao.getSingleHabit(habitId)
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
        }
        return Rezults.Success(selectedHabit)
    }

    override suspend fun getAllHabits(
        userId: Long,
        selectedHabit: HabitWithGoalEntity
    ): Rezults<List<HabitWithGoalEntity>> {
        try {
            kaiznDao.getAllHabits()
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
        }
        return Rezults.Success(listOf(selectedHabit))
    }
}