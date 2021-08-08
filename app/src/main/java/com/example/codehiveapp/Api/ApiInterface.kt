package com.example.codehiveapp.Api

import com.example.codehiveapp.modules.LoginRequest
import com.example.codehiveapp.modules.LoginResponse
import com.example.codehiveapp.modules.RegistrationRequest
import com.example.codehiveapp.modules.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
   suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>
   suspend fun loginStudent(@Body loginRequest: LoginRequest):Call<LoginResponse>
}
