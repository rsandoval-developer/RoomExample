package com.ia.roomexample.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * The Room database that contains the Users table
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}