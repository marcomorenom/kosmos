package com.example.android.roomwordssample.domain.dtos

import com.google.gson.annotations.SerializedName

data class UserPageDTO(
    @SerializedName("page") val page: Int
)