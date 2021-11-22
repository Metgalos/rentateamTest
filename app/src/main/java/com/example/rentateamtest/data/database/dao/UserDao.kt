package com.example.rentateamtest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rentateamtest.data.database.entity.UserDb
import io.reactivex.Maybe

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userDb: UserDb)

    @Insert
    fun insert(userDb: List<UserDb>)

    @Query("DELETE FROM userdb")
    fun clear()

    @Query("SELECT * FROM userdb")
    fun get(): Maybe<List<UserDb>>

    @Query("SELECT * FROM userdb WHERE id = :id LIMIT 1")
    fun getById(id: Int): Maybe<UserDb>
}