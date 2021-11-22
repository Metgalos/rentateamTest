package com.example.rentateamtest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rentateamtest.data.database.dao.UserDao
import com.example.rentateamtest.data.database.entity.UserDb

@Database(entities = [UserDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "app_database"
    }
}