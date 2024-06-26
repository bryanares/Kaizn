package com.brian.kaizn.features.habit_history.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.kaizn.data.di.DefaultDispatcher
import com.brian.kaizn.data.di.IoDispatcher
import com.brian.kaizn.data.di.MainDispatcher
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.repository.KaiznRepository
import com.brian.kaizn.data.utils.Rezults
import com.brian.kaizn.features.habit_history.domain.model.KaiznUiEvents
import com.brian.kaizn.features.habit_history.domain.model.KaiznUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KaiznViewModel @Inject constructor(
    private val kaiznRepository: KaiznRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _kaiznUiState = MutableStateFlow(KaiznUiStates())
    val kaiznUiState = _kaiznUiState.asStateFlow()

    private val _kaiznUiEvent = Channel<KaiznUiEvents>()
    val kaiznUiEvent = _kaiznUiEvent.receiveAsFlow()


    fun createHabit(newHabit: HabitEntity) {
        viewModelScope.launch(ioDispatcher) {
            _kaiznUiState.update {
                it.copy(isLoading = true)
            }

            val createdHabit = kaiznRepository.createNewHabit(newHabit)

            when (createdHabit) {
                is Rezults.Success -> {
                    _kaiznUiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccessful = true,
                            habitId = createdHabit.data.toString()
                        )
                    }
                }

                is Rezults.Error -> {
                    _kaiznUiEvent.send(KaiznUiEvents.Error(message = createdHabit.message))
                }
            }
        }
        _kaiznUiState.update {
            it.copy(isLoading = false)
        }
    }

    fun updateHabit() {

    }

    fun deleteHabit(habit: HabitEntity) {
        viewModelScope.launch(ioDispatcher) {
            _kaiznUiState.update {
                it.copy(isLoading = true)
            }
            val deletedhabit = kaiznRepository.deleteSingleHabit(habit)
            when (deletedhabit) {
                is Rezults.Success -> {
                    _kaiznUiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccessful = true,
                            singleDeletedHabit = deletedhabit
                        )
                    }
                }

                is Rezults.Error -> {
                    _kaiznUiEvent.send(KaiznUiEvents.Error(message = deletedhabit.message))
                }
            }
        }
        _kaiznUiState.update {
            it.copy(isLoading = false)
        }

    }

    fun getSingleHabit(habitId: Long) {
        viewModelScope.launch(ioDispatcher) {
            _kaiznUiState.update {
                it.copy(isLoading = true)
            }
            val habit = kaiznRepository.getSingleHabit(habitId)
            when (habit) {
                is Rezults.Success -> {
                    _kaiznUiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccessful = true,
                            singleSelectedHabit = habit.data
                        )
                    }
                }

                is Rezults.Error -> {
                    //
                    _kaiznUiEvent.send(KaiznUiEvents.Error(message = habit.message))
                }
            }
            _kaiznUiState.update {
                it.copy(isLoading = false)
            }

        }

    }

    fun getAllHabits() {
        viewModelScope.launch(ioDispatcher) {
            _kaiznUiState.update {
                it.copy(isLoading = true)
            }
            val habitList = kaiznRepository.getAllHabits()
            when (habitList) {
                is Rezults.Success -> {
                    _kaiznUiState.update {
                        it.copy(
                            isLoading = false,
                            isSuccessful = true,
                            habitList = habitList.data
                        )
                    }
                }

                is Rezults.Error -> {
                    _kaiznUiEvent.send(KaiznUiEvents.Error(message = habitList.message))
                }
            }
            _kaiznUiState.update {
                it.copy(isLoading = false)
            }
        }

    }
}