package com.brian.kaizn.data.repository

import android.util.Log
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.utils.Rezults
import javax.inject.Inject

class KaiznRepositoryImplementation @Inject constructor(private val kaiznDao: KaiznDao) :
    KaiznRepository {
    override suspend fun createNewHabit(newHabit: HabitEntity): Rezults<Long> {
        return try {
            val result = kaiznDao.insertNewHabit(newHabit)
            Rezults.Success(result)
        } catch (e: Error) {
            Rezults.Error(e.message)
        }
    }

    override suspend fun updateExistingHabit(existingHabit: HabitWithGoalEntity): Rezults<ReturnNothing> {
        try {
            kaiznDao.updateExistingHabit(existingHabit)
            return Rezults.Success(ReturnNothing())
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
            return Rezults.Error(e.message)
        }
    }

    override suspend fun deleteSingleHabit(habit: HabitWithGoalEntity): Rezults<ReturnNothing> {
        return try {
            kaiznDao.deleteHabit(habit)
            Rezults.Success(ReturnNothing())
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
            Rezults.Error(e.message)
        }

    }

    override suspend fun getSingleHabit(habitId: Long): Rezults<HabitWithGoalEntity> {
        return try {
            val result = kaiznDao.getHabitWithGoal(habitId)
            Rezults.Success(result)
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
            Rezults.Error(e.message)
        }

    }

    override suspend fun getAllHabits(): Rezults<List<HabitWithGoalEntity>> {
        return try {
            val allHabits = kaiznDao.getAllHabits()
            Rezults.Success(allHabits)
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
            Rezults.Error(e.message)
        }
    }
}