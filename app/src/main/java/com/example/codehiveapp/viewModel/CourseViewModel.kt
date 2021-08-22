package com.example.codehiveapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveapp.Repository.CoursesRepository
import com.example.codehiveapp.courses.CourseResponse
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class CourseViewModel :ViewModel(){
    var courseLiveData=MutableLiveData<List<CourseResponse>>()
    var courseFailedLiveData=MutableLiveData<String>()
    var coursesRepository=CoursesRepository()

    fun getCourses(accessToken: String){
        viewModelScope.launch{
            var response=coursesRepository.courses(accessToken)
            if(response.isSuccessful){
                courseLiveData.postValue(response.body())
            }
            else{
                courseFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}