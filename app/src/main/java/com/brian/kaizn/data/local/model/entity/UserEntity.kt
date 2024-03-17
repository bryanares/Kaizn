package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var userName: Long? = null,
    var userFirstName: Long? = null,
    var userLastName: Long? = null,
    var userEmail: Long? = null
)