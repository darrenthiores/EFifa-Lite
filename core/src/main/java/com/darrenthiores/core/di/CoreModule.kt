package com.darrenthiores.core.di

import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.darrenthiores.core.BuildConfig
import com.darrenthiores.core.data.dataStore.DataStore
import com.darrenthiores.core.data.local.LocalDataSource
import com.darrenthiores.core.data.local.PlayerDb
import com.darrenthiores.core.data.remote.ktor.FootballService
import com.darrenthiores.core.data.remote.ktor.FootballServiceImpl
import com.darrenthiores.core.data.remote.source.RemoteDataSource
import com.darrenthiores.core.data.repository.FootballRepository
import com.darrenthiores.core.data.repository.IFootballRepository
import com.darrenthiores.core.utils.PrepopulateHelper
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    factory { get<PlayerDb>().startingDao() }

    factory { get<PlayerDb>().userPlayerDao() }

    single {

        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.PASSWORD.toCharArray())
        val factory = SupportFactory(passphrase)

        Room.databaseBuilder(
            androidContext(),
            PlayerDb::class.java,
            "Football.db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                PrepopulateHelper.fillWithStartingData(get())
                PrepopulateHelper.fillWithUserPlayer(get())
            }
        })
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()

    }

}

val networkModule = module {
    single {
        val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(HttpTimeout) { // Timeout
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
        }
    }
    single<FootballService> { FootballServiceImpl(get()) }
}

@ExperimentalPagingApi
val repositoryModule = module {

    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single { DataStore(androidContext()) }

    single<IFootballRepository> { FootballRepository(get(), get(), get()) }

}