package com.darrenthiores.core.model.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserPlayerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var playerId: Int,
    var name: String,
    var age: Int,
    var nationality: String,
    var height: String,
    var weight: String,
    var photo: String,
    var club: String,
    var clubPhoto: String,
    var league: Int,
    var position: String,
    var rating: Double,
    var level: Int
)
