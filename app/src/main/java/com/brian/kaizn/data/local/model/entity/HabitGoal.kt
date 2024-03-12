package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitGoal(
    @PrimaryKey(autoGenerate = true) val habitGoalId: Long,
    var habitGoalName: Long? = null,
    var habitGoalInspiration: Long? = null,
    var habitGoalReward: Long? = null
    )
