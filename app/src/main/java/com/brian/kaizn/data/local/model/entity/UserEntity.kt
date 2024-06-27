package com.brian.kaizn.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    val id : String? =null,
    var userName: Long? = null,
    var userFirstName: Long? = null,
    var userLastName: Long? = null,
    var userEmail: Long? = null
)