package com.example.android.roomwordssample.applicaiton.repositories

import com.example.android.roomwordssample.domain.dtos.UserPageDTO
import com.example.android.roomwordssample.framework.apiClient.services.UserService
import retrofit2.Retrofit
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val client: Retrofit
): UserRepository {
    override suspend fun getUsersPage(): UserPageDTO {
        return client.create(UserService::class.java).getUsers()
    }
}