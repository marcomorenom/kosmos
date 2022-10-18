package com.example.android.roomwordssample.domain

sealed class WordValidatorStatus {
    object InvalidEmpty: WordValidatorStatus()
    object Valid: WordValidatorStatus()
}