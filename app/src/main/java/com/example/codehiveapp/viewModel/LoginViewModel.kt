package com.example.codehiveapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveapp.Repository.CoursesRepository
import com.example.codehiveapp.Repository.UserRepository
import com.example.codehiveapp.courses.CourseResponse
import com.example.codehiveapp.modules.LoginRequest
import com.example.codehiveapp.modules.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var loginLiveData = MutableLiveData<List<LoginResponse>>()
    var loginFailedLiveData = MutableLiveData<String>()
    var userRepository =UserRepository()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch{
            var response=userRepository.login(loginRequest)
            if(response.isSuccessful){
                loginLiveData.postValue(response.body())
            }else{
                loginFailedLiveData.postValue(response.errorBody()?.string())
            }
        }

    }
}

