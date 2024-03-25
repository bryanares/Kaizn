package com.brian.kaizn.features.habit_history.domain.model

import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitWithGoalEntity

data class KaiznUiStates (
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: String? = null,
    val habitId: String? = null,
    val createdHabit: HabitWithGoalEntity? = null,
    val updatedHabit: HabitWithGoalEntity? = null,
    val singleSelectedHabit: HabitWithGoalEntity? = null,
    val habitList: List<HabitWithGoalEntity>? = null,
    val message: String? = null

)