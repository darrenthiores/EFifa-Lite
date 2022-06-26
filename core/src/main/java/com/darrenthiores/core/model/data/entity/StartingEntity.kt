package com.darrenthiores.core.model.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StartingEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val playerId: Int,
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
    val rating: Double,
    var level: Int,
    var place: Int
)
