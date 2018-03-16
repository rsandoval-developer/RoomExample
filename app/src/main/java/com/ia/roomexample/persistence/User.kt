package com.ia.roomexample.persistence


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class User(@PrimaryKey
                @ColumnInfo(name = "userid")
                var id: String = UUID.randomUUID().toString(),
                @ColumnInfo(name = "username")
                var userName: String = "")