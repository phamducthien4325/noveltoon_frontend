package com.example.noveltoon.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noveltoon.data.local.dao.UserDao
import com.example.noveltoon.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}