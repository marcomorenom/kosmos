package com.example.android.roomwordssample.domain.utils

import com.example.android.roomwordssample.domain.Word

interface WordValidator {

    fun isWordValid(word: Word): Boolean

}