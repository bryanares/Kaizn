package com.brian.kaizn.data.local.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brian.kaizn.data.local.dao.KaiznDao
import com.brian.kaizn.data.local.model.entity.HabitEntity
import com.brian.kaizn.data.local.model.entity.HabitGoalEntity
import com.brian.kaizn.data.local.model.entity.UserEntity


@Database(
    entities = [HabitEntity::class, HabitGoalEntity::class, UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class KaiznRoomDatabase : RoomDatabase() {
    abstract fun KaiznDao(): KaiznDao
}