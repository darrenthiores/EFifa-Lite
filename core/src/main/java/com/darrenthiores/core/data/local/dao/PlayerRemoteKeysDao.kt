package com.darrenthiores.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darrenthiores.core.model.data.entity.PlayerRemoteKeys

@Dao
interface PlayerRemoteKeysDao {
    @Query("SELECT * FROM playerremotekeys WHERE id =:id")
    suspend fun getRemoteKeys(id: Int): PlayerRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<PlayerRemoteKeys>)

    @Query("DELETE FROM playerremotekeys")
    suspend fun deleteAllRemoteKeys()
}