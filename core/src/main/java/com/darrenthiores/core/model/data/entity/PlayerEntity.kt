package com.darrenthiores.core.model.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    val remoteId: Int = 0,
    val id: Int,
    val name: String,
    val age: Int,
    val nationality: String,
    val height: String,
    val weight: String,
    val photo: String,
    val club: String,
    val clubPhoto: String,
    val league: Int,
    val position: String,
    val rating: Double
)
