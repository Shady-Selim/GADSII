package com.example.gadsii.data

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {
    @GET("hours")
    suspend fun getHoursApi(): ArrayList<GADSData>

    @GET("skilliq")
    suspend fun getSkilliqApi(): ArrayList<GADSData>

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun formSendApi(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") linkToProject: String
    ): Call<Void>
}
