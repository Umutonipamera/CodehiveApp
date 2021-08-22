package com.example.codehiveapp.Api

import com.example.codehiveapp.modules.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
   suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>
   @POST("/student/login")
   suspend fun loginStudent(@Body loginRequest: LoginRequest):Call<LoginResponse>
   @GET("/courses")
   suspend fun  getCourses(@Header("Authorization") token:String):Response<List<CourseResponse>>
   @POST("enrolment")
   suspend fun  getEnrolment(@Header("Authorizationm") token: String):Response<EnrolmentResponse>
}
