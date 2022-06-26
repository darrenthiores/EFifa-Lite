package com.darrenthiores.core.data.local.dao

import androidx.room.*
import com.darrenthiores.core.model.data.entity.UserPlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPlayerDao {
    // user players
    @Insert
    fun initialUserPlayer(vararg userPlayers: UserPlayerEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserPlayer(player: UserPlayerEntity)

    @Query("SELECT * FROM userplayerentity ORDER BY rating DESC")
    fun getUserPlayers(): Flow<List<UserPlayerEntity>>

    @Query("SELECT * FROM userplayerentity WHERE position = :position ORDER BY rating DESC")
    fun getPlayersByPosition(position: String): Flow<List<UserPlayerEntity>>

    @Update
    suspend fun updateUserPlayer(player: UserPlayerEntity)

    @Delete
    suspend fun deleteUserPlayer(player: UserPlayerEntity)
}