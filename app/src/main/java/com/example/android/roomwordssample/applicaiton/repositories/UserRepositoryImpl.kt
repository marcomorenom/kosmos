package com.example.android.roomwordssample.applicaiton.repositories

import com.example.android.roomwordssample.domain.User

class UserRepositoryImpl: UserRepository {
    override fun getUsers(): User {
        return User("testing...")
    }
}