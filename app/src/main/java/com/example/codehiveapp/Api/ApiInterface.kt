package com.example.codehiveapp.Api

import com.example.codehiveapp.modules.RegistrationRequest
import com.example.codehiveapp.modules.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>
}
