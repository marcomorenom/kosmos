package com.example.android.roomwordssample.applicaiton.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.roomwordssample.domain.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAlphabetizedWords(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: User)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
