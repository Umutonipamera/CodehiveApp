package com.example.codehiveapp.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.codehiveapp.Repository.UserRepository
import com.example.codehiveapp.modules.RegistrationRequest
import com.example.codehiveapp.modules.RegistrationResponse

class UserViewModel {
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var regFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()




    fun registerUser(registrationRequest: RegistrationRequest){
        ViewModelScope.launch {
        var response = userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                regFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}







