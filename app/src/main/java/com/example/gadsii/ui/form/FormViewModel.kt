package com.example.gadsii.ui.form

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.gadsii.data.Apifactory
import com.example.gadsii.repo.Repo
import kotlinx.coroutines.launch
import java.lang.Exception

class FormViewModel(context: Application): AndroidViewModel(context) {
    private val repo: Repo

    var success = true

    fun postForm(emailAddress: String, name: String, lastName: String, linkToProject: String): Boolean {
        viewModelScope.launch {
            try {
                repo.postForm(emailAddress, name, lastName, linkToProject)
            } catch (e: Exception) {
                success = false
                Log.e("Get HOURS:", "Error")
            }
        }
        return success
    }

    init {
        repo = Repo(Apifactory.retrofitApi)
    }
}
