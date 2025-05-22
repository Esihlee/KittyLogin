package com.example.kittylogin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val studentNumber: String,
    val name: String,
    val surname: String,
    val email: String,
    val password: String
)
