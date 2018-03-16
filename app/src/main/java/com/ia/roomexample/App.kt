package com.ia.roomexample

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.ia.roomexample.persistence.AppDatabase

/**
 * Created by rsandoval on 16/03/2018.
 */
class App : Application() {


    companion object {
        lateinit var instance: App
    }


    @Volatile
    private var databaseInstance: AppDatabase? = null

    fun getDataBaseInstance(): AppDatabase =
            databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabase(this).also { databaseInstance = it }
            }

    private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "Sample.db")
                    .build()


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}