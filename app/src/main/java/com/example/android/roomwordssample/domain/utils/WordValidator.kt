package com.example.android.roomwordssample.domain.utils

import com.example.android.roomwordssample.domain.businessEntities.Word

interface WordValidator {

    fun isWordValid(word: Word): Boolean

}