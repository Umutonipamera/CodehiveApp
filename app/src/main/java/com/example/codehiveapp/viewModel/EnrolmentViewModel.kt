package com.example.codehiveapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveapp.Repository.CoursesRepository
import com.example.codehiveapp.modules.EnrolmentResponse
import kotlinx.coroutines.launch

class EnrolmentViewModel :ViewModel(){
    var enrolmentLiveData= MutableLiveData<EnrolmentResponse>()
    var enrolmentFailedLiveData=MutableLiveData<String>()
    var courseRepository=CoursesRepository()

    fun getEnrolment(accessToken:String){
        viewModelScope.launch{
            var response=courseRepository.enrolment(accessToken)
            if(response.isSuccessful){
                enrolmentLiveData.postValue(response.body())
            }
            else{
                enrolmentFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}