package com.darrenthiores.core.data.local.dao

import androidx.room.*
import com.darrenthiores.core.model.data.entity.StartingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StartingDao {
    // user starting
    @Insert
    fun initialStarting(vararg starting: StartingEntity)

    @Insert
    suspend fun insertStarting(starting: StartingEntity)

    @Query("SELECT * FROM startingentity ORDER BY place")
    fun getStarting(): Flow<List<StartingEntity>>

    @Query("SELECT * FROM startingentity WHERE id = :id")
    fun getStartingById(id: Int): Flow<StartingEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM startingentity WHERE playerId = :playerId)")
    suspend fun checkStartingExist(playerId: Int): Int

    @Update
    suspend fun updateUserStarting(player: StartingEntity)

    @Delete
    suspend fun deleteUserStarting(player: StartingEntity)
}