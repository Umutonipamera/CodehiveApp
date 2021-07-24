package com.example.codehiveapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter ( var courseList: List<Courses>): RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
//    on creates creates an instance of the viewHolder
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        return CourseViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
//       to sets attributes in a posional way and binds the views to the view holder for it
//        to display in a recycler view.
        var currentCourse=courseList.get(position)
        holder.tvCourseName.text=currentCourse.courseName
        holder.tvDiscribution.text=currentCourse.description
        holder.tvCode.text=currentCourse.courseCode
        holder.tvInstructor.text=currentCourse.instructor

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    //    getting the individual views
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDiscribution=itemView.findViewById<TextView>(R.id.tvDiscribution)

    var tvCode=itemView.findViewById<TextView>(R.id.tvCode)
    var tvInstructor=itemView.findViewById<TextView>(R.id.tvInstructor)
}
