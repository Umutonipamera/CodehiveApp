package com.example.codehiveapp.Repository

import com.example.codehiveapp.Api.ApiClient
import com.example.codehiveapp.Api.ApiInterface
import com.example.codehiveapp.courses.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {


    var apiInterface=ApiClient.buildApiClient((ApiInterface::class.java))
    suspend fun courses(accessToken:String ):Response<List<CourseResponse> =withContext(Dispatchers.IO){
        var response=apiInterface.getCourses(accessToken)
        return@withContext response
        }
    suspend fun enrolment(accessToken: String):Response<EnrolmentResponse> =
    withContext(Dispatchers.IO){
        var enrol=apiInterface.getEnrolment(accessToken)
        return@withContext enrol
    }


}
