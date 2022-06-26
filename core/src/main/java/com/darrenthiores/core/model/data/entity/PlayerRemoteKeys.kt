package com.darrenthiores.core.model.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerRemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prevPage: Int?,
    val nextPage: Int?
)
