package com.darrenthiores.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darrenthiores.core.data.local.dao.PlayerDao
import com.darrenthiores.core.data.local.dao.PlayerRemoteKeysDao
import com.darrenthiores.core.data.local.dao.StartingDao
import com.darrenthiores.core.data.local.dao.UserPlayerDao
import com.darrenthiores.core.model.data.entity.PlayerEntity
import com.darrenthiores.core.model.data.entity.PlayerRemoteKeys
import com.darrenthiores.core.model.data.entity.StartingEntity
import com.darrenthiores.core.model.data.entity.UserPlayerEntity

@Database(
    entities = [PlayerEntity::class, UserPlayerEntity::class, StartingEntity::class, PlayerRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class PlayerDb: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    abstract fun userPlayerDao(): UserPlayerDao

    abstract fun startingDao(): StartingDao

    abstract fun playerRemoteKeysDao(): PlayerRemoteKeysDao

}