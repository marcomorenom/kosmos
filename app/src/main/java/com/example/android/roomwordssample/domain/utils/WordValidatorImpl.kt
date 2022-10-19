package com.example.android.roomwordssample.domain.utils

import com.example.android.roomwordssample.domain.businessEntities.Word

class WordValidatorImpl() : WordValidator {

    override fun isWordValid(word: Word): Boolean {
        return word.timeStamp >0 && word.word.isNotEmpty() && word.country.isNotEmpty()
    }
}