package com.darrenthiores.core.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.darrenthiores.core.model.data.entity.PlayerEntity

@Dao
interface PlayerDao {

    // load data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(players: List<PlayerEntity>)

    @Query("SELECT * FROM playerentity WHERE league = :league ORDER BY remoteId")
    fun getPlayers(league: Int): PagingSource<Int, PlayerEntity>

    @Query("DELETE FROM playerentity")
    suspend fun clearAll()

}