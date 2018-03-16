package com.ia.roomexample

import com.ia.roomexample.persistence.User
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by rsandoval on 16/03/2018.
 */
class Interactor {

    fun insertUser(callback: Callback) {
        doAsync {
            val users: List<User> = App.instance.getDataBaseInstance().userDao().getAllUsers()
            uiThread {
                callback.getUsers(users)
            }
        }
    }


    interface Callback {
        fun getUsers(users: List<User>)
    }

}