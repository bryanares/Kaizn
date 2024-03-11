package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) val id: Long,
    var userName: Long? = null,
    var userFirstName: Long? = null,
    var userLastName: Long? = null,
    var userEmail: Long? = null
)