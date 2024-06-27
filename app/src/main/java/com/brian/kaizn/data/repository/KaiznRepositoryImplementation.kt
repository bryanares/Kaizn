package com.brian.kaizn.data.repository

import android.util.Log
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity
import com.brian.kaizn.data.local.model.entity.UserEntity
import com.brian.kaizn.data.utils.Rezults
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class KaiznRepositoryImplementation @Inject constructor(
    private val kaiznDao: KaiznDao,
    private val firebaseAuth: FirebaseAuth,
    private val jotFirebaseFirestore: FirebaseFirestore
) :
    KaiznRepository {


    //sign in functionality, return user, or error
    override suspend fun signIn(email: String, password: String): Flow<Rezults<UserEntity>> {
        return callbackFlow {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        this.trySend(
                            Rezults.Success(
                                UserEntity(
                                    firebaseAuth.currentUser!!.uid
                                )
                            )
                        ).isSuccess


                    } else {
                        this.trySend(
                            Rezults.Error(
                                "",
                                task.exception!!
                            )
                        ).isSuccess
                    }
                }
            awaitClose { this.cancel() }
        }
    }

    //sign up functionality, create user, add user to database, and return user, or error
    override suspend fun signUp(
        email: String,
        password: String,
        name: String
    ): Flow<Rezults<UserEntity>> {
        return callbackFlow {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        this.trySend(
                            Rezults.Success(
                                UserEntity(
                                    firebaseAuth.currentUser!!.uid
                                )
                            )
                        ).isSuccess

                    } else {
                        this.trySend(
                            Rezults.Error(
                                "",
                                task.exception!!
                            )
                        ).isSuccess
                    }
                }
            awaitClose { this.cancel() }
        }
    }

    override suspend fun createNewHabit(newHabit: HabitEntity): Rezults<Long> {
        return try {
            val result = kaiznDao.insertNewHabit(newHabit)
            Rezults.Success(result)
        } catch (e: Error) {
            Rezults.Error(e.message)
        }
    }

    override suspend fun updateExistingHabit(existingHabit: HabitEntity): Rezults<ReturnNothing> {
        try {
            kaiznDao.updateExistingHabit(existingHabit)
            return Rezults.Success(ReturnNothing())
        } catch (e: Error) {
            Log.d("repo", e.message.toString())
            return Rezults.Error(e.message)
        }
    }

    override suspend fun deleteSingleHabit(habit: HabitEntity): Rezults<ReturnNothing> {
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