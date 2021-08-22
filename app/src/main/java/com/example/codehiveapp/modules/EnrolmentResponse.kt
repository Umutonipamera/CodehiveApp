package com.example.codehiveapp.modules

import com.google.gson.annotations.SerializedName

data class EnrolmentResponse(
    @SerializedName("course_id") var courseId:String,
    @SerializedName("student_id") var studentId:String
)
