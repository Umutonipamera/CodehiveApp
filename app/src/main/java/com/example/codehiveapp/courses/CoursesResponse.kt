package com.example.codehiveapp.courses

import com.google.gson.annotations.SerializedName

class CoursesResponse (

    var message:String,
    @SerializedName("access_token") var accessToken:String,
    @SerializedName("student_id") var studentId:String,

)