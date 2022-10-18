package com.example.android.roomwordssample.applicaiton.repositories

import com.example.android.roomwordssample.domain.User

interface UserRepository {

    fun getUsers(): User
}