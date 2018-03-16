package com.ia.roomexample.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by rsandoval on 16/03/2018.
 */
@Dao
interface UserDao {

    /**
     * Get a user by id.
     * @return the user from the table with a specific id.
     */
    @Query("SELECT * FROM users WHERE userid = :arg0")
    fun getUserById(id: String): User?

    /**
     * Insert a user in the database. If the user already exists, replace it.
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    /**
     * Delete all users.
     */
    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>
}