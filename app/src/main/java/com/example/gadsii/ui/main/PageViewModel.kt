package com.example.gadsii.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.gadsii.data.Apifactory
import com.example.gadsii.data.GADSData
import com.example.gadsii.repo.Repo
import kotlinx.coroutines.launch
import java.lang.Exception

class PageViewModel(context: Application): AndroidViewModel(context) {
    private val repo: Repo

    fun getData(i: Int): MutableLiveData<ArrayList<GADSData>> {
        val messages = MutableLiveData<ArrayList<GADSData>>()
        viewModelScope.launch {
            try {
                if (i == 1)
                    messages.postValue(repo.getHours())
                else
                    messages.postValue(repo.getSkillsIq())

            } catch (e: Exception) {
                Log.e("Get HOURS:", "Error")
            }
        }
        return messages
    }

    init {
        repo = Repo(Apifactory.retrofitApi)
    }

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}