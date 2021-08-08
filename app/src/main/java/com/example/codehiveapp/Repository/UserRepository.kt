package com.example.codehiveapp.Repository

import android.view.KeyEvent
import com.example.codehiveapp.Api.ApiClient
import com.example.codehiveapp.Api.ApiInterface
import com.example.codehiveapp.modules.LoginRequest
import com.example.codehiveapp.modules.LoginResponse
import com.example.codehiveapp.modules.RegistrationRequest
import com.example.codehiveapp.modules.RegistrationResponse
import okhttp3.Dispatcher
import retrofit2.Response


class UserRepository{
    var apiInterface=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatcher.IO{

             var response=apiInterface.registerStudent(registrationRequest)
             return@withContext response
            })
}
    suspend fun login(loginRequest: LoginRequest):Response<LoginResponse> =
       withContext(Dispatchers.IO){
    var response = apiInterface.loginStudent(loginRequest)
    return@withContext response

}



