package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val habitId: Long = 0,
    var habitName: Long? = null,
    var habitDailyTarget: Int? = null,
    var habitUnit: Long? = null,
    var habitCreatedDate: Long? = null,
    var habitStartDate: Long? = null,
    var habitProjectedEndDate: Long? = null,
    //do I create a separate model or utils for interval?
    var habitInterval: Long? = null,
)
