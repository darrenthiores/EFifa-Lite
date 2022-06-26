package com.darrenthiores.core.data.local

import androidx.paging.PagingSource
import com.darrenthiores.core.model.data.entity.PlayerEntity
import com.darrenthiores.core.model.data.entity.PlayerRemoteKeys
import com.darrenthiores.core.model.data.entity.StartingEntity
import com.darrenthiores.core.model.data.entity.UserPlayerEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val playerDb: PlayerDb
) {

    fun getDb(): PlayerDb = playerDb

    private val playerDao = playerDb.playerDao()
    private val userPlayerDao = playerDb.userPlayerDao()
    private val startingDao = playerDb.startingDao()
    private val playerRemoteKeysDao = playerDb.playerRemoteKeysDao()

    // load data
    suspend fun insert(players: List<PlayerEntity>) {
        playerDao.insert(players)
    }

    fun getPlayers(league: Int): PagingSource<Int, PlayerEntity> =
        playerDao.getPlayers(league)

    suspend fun clearAll() = playerDao.clearAll()

    suspend fun getRemoteKeys(id: Int): PlayerRemoteKeys = playerRemoteKeysDao.getRemoteKeys(id)

    suspend fun addAllRemoteKeys(remoteKeys: List<PlayerRemoteKeys>) = playerRemoteKeysDao.addAllRemoteKeys(remoteKeys)

    suspend fun deleteAllRemoteKeys() = playerRemoteKeysDao.deleteAllRemoteKeys()

    // user players
    suspend fun insertUserPlayer(player: UserPlayerEntity) {
        userPlayerDao.insertUserPlayer(player)
    }

    fun getUserPlayers(): Flow<List<UserPlayerEntity>> =
        userPlayerDao.getUserPlayers()

    fun getPlayersByPosition(position: String): Flow<List<UserPlayerEntity>> =
        userPlayerDao.getPlayersByPosition(position)

    suspend fun updateUserPlayer(player: UserPlayerEntity) {
        userPlayerDao.updateUserPlayer(player)
    }

    suspend fun deleteUserPlayer(player: UserPlayerEntity) {
        userPlayerDao.deleteUserPlayer(player)
    }

    // user starting
    suspend fun insertStarting(starting: StartingEntity) {
        startingDao.insertStarting(starting)
    }

    fun getStarting(): Flow<List<StartingEntity>> =
        startingDao.getStarting()

    fun getStartingById(playerId: Int): Flow<StartingEntity> =
        startingDao.getStartingById(playerId)

    suspend fun checkStartingExist(playerId: Int): Int =
        startingDao.checkStartingExist(playerId)

    suspend fun updateUserStarting(player: StartingEntity) {
        startingDao.updateUserStarting(player)
    }

    suspend fun deleteUserStarting(player: StartingEntity) {
        startingDao.deleteUserStarting(player)
    }
}