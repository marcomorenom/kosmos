package com.example.android.roomwordssample.framework.apiClient.services

import com.example.android.roomwordssample.domain.dtos.UserPageDTO
import retrofit2.http.GET

interface UserService {

    @GET("users?page=2") suspend fun getUsers() : UserPageDTO

}