package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true) val habitId: Long,
    var habitName: Long? = null,
    var habitDailyTarget: Int? = null,
    var habitUnit: Long? = null,
    var habitStartDate: Long? = null,
    var habitProjectedEndDate: Long? = null,
    //do I create a separate model or utils for interval?
    var habitInterval: Long? = null,
)
