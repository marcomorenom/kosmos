package com.example.android.roomwordssample.domain.businessEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "user_table")
data class User(
    @PrimaryKey @ColumnInfo(name = "name")
    @SerializedName("name") val name: String
)
