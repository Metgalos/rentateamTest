package com.example.rentateamtest.data.repository

import android.util.Log
import com.example.rentateamtest.data.database.DbMapper
import com.example.rentateamtest.data.database.dao.UserDao
import com.example.rentateamtest.data.database.entity.UserDb
import com.example.rentateamtest.data.network.UsersApiService
import com.example.rentateamtest.data.response.ResponseMapper
import com.example.rentateamtest.domain.model.User
import com.example.rentateamtest.domain.repository.UsersRepository
import io.reactivex.Single
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: UsersApiService,
    private val responseMapper: ResponseMapper,
    private val dbMapper: DbMapper,
    private val userDao: UserDao,
) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return api.getUsers()
            .map(responseMapper::mapUserListResponse)
            .onErrorResumeNext {
                Log.e("UsersRepository", it.message ?: "", it)
                userDao.get()
                    .switchIfEmpty(Single.fromCallable { emptyList() })
                    .map(dbMapper::mapListUserDbToUser)
            }
            .doOnSuccess {
                userDao.clear()
                userDao.insert(dbMapper.mapListUserToUserDb(it))
            }
    }

    override fun getUser(id: Int): Single<User> {
        return api.getUser(id)
            .map(responseMapper::mapBaseUserResponse)
            .onErrorResumeNext {
                Log.e("UsersRepository", it.message ?: "", it)
                userDao.getById(id)
                    .switchIfEmpty(Single.fromCallable { UserDb.createEmpty() })
                    .map(dbMapper::mapUserDbToUser)
            }
            .doOnSuccess { userDao.insert(dbMapper.mapUserToDb(it)) }
    }
}
