package com.example.android.roomwordssample.applicaiton.viewmodels

import androidx.lifecycle.ViewModel
import com.example.android.roomwordssample.applicaiton.repositories.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
private val repository: WordRepository //todo change this implementation
): ViewModel() {



}