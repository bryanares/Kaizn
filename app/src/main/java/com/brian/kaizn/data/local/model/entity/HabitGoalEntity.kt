package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitGoalEntity(
    @PrimaryKey(autoGenerate = true) val habitGoalId: Long = 0,
    var habitGoalName: Long? = null,
    var habitGoalInspiration: Long? = null,
    var habitGoalReward: Long? = null,
    var habitGoalCreatedAt: Long? = null,
    var habitGoalUpdatedAt: Long? = null
    )
