package com.example.gadsii.repo

import com.example.gadsii.data.ApiClient
import com.example.gadsii.data.GADSData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import java.util.ArrayList

class Repo(private val api: ApiClient) {
    suspend fun getHours(): ArrayList<GADSData> = withContext(Dispatchers.IO) {
        api.getHoursApi()
    }
    suspend fun getSkillsIq(): ArrayList<GADSData> = withContext(Dispatchers.IO) {
        api.getSkilliqApi()
    }
    suspend fun postForm(emailAddress: String, name: String, lastName: String, linkToProject: String): Call<Void> = withContext(Dispatchers.IO) {
        api.formSendApi(emailAddress, name, lastName, linkToProject)
    }
}