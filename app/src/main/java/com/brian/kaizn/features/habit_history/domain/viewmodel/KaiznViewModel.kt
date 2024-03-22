package com.brian.kaizn.features.habit_history.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.brian.kaizn.data.repository.KaiznRepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KaiznViewModel @Inject constructor(
    private val kaiznRepository: KaiznRepositoryImplementation
) : ViewModel() {


    fun createHabit() {

    }

    fun updateHabit() {

    }

    fun deleteHabit() {

    }

    fun getSingleHabit() {

    }

    fun getAllHabits() {

    }

}