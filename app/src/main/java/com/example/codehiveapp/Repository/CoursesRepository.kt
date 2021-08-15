package com.example.codehiveapp.Repository

import com.example.codehiveapp.Api.ApiClient
import com.example.codehiveapp.Api.ApiInterface
import com.example.codehiveapp.courses.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {


    var apiInterface=ApiClient.buildApiClient((ApiInterface::class.java))
    suspend fun coursesRes(courseResponse: CourseResponse):
            Response<CourseResponse> =
        withContext(Dispatchers.IO){
            var response = apiInterface.coursesRes(courseResponse)
            return@withContext response
        }



}
