package com.brian.kaizn.data.local.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

//habit with goal
/**query HabitEntity first, get habitId then query HabitGoalEntity and search for corresponding value
under the foreign key column name habitEntityId
 */

@Entity
data class HabitWithGoalEntity(
    @Embedded val habitEntity: HabitEntity,
    @Relation(
        parentColumn = "habitId",
        entityColumn = "habitEntityId"
    )
    val habitGoalEntity: HabitGoalEntity
)