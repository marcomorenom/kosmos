package com.example.android.roomwordssample.applicaiton.repositories

import com.example.android.roomwordssample.domain.dtos.UserPageDTO

interface UserRepository {

    suspend fun getUsersPage(): UserPageDTO
}