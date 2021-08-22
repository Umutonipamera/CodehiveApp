package com.example.codehiveapp

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveapp.modules.CourseResponse
import com.example.codehiveapp.modules.EnrolmentRequest
import com.example.codehiveapp.viewModel.Constants
import com.example.codehiveapp.viewModel.EnrolmentViewModel
import java.util.prefs.AbstractPreferences


class CoursesResponseAdapter(var courseResponseList: List<CourseResponse>):RecyclerView.Adapter<CoursesResponseViewHolder>()
      private lateinit var enrolmentViewModel: EnrolmentViewModel
      private lateinit var sharedPreferences: SharedPreferences
      override fun onCreateViewHolder(parent:ViewGroup,viewType: Int):CoursesResponseViewHolder{
          var itemView=LayoutInflater.from(parent.context.inflate(R.layout.course_response_list_item,parent,false))
          return CoursesResponseViewHolder(itemView)
      }
override fun onBindViewHolder(holder: CoursesResponseViewHolder,position: Int){
    var currentCourseResponse=courseResponseList.get(position)
    holder.tvcourseName.text=currentCourseResponse.courseName
    holder.tvcourseId.text=currentCourseResponse.courseId
    holder.tvinstructor.text=currentCourseResponse.instructor
    holder.tvdescription.text=currentCourseResponse.description
    holder.btnEnrol.setOnClickListener{
        sharedPreferences= sharedPreferences
        var studentId= sharedPreferences.edit()
        var courseId= sharedPreferences.edit()
        var enrolmentRequest=EnrolmentRequest(
            studentId = studentId.toString(),
            courseId =courseId.toString()

        )
        EnrolmentViewModel.getEnrolment(Constants.toString())
    }
}
override fun getItemCount():Int{
    return courseResponseList.size


}
class  CoursesResponseViewHolder(itemView: View):RecylerView.ViewHolder(itemView){
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseId=itemView.findViewById<TextView>(R.id.tvCode)
    var tvDiscription=itemView.findViewById<TextView>(R.id.tvDiscribution)
    var tvInstructor=itemView.findViewById<TextView>(R.id.tvInstructor)
    var btnEnrolment=itemView.findViewById<TextView>(R.id.btnEnrolment)
}

