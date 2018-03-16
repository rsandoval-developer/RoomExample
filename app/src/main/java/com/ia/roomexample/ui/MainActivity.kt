package com.ia.roomexample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ia.roomexample.Interactor
import com.ia.roomexample.R
import com.ia.roomexample.persistence.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Interactor().insertUser(object : Interactor.Callback {
                override fun getUsers(users: List<User>) {
                    println(users)
                }
            })

        }
    }


}
