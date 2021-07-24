package com.example.codehiveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses2)
        var rvcourses=findViewById<RecyclerView>(R.id.rvCourses)
        var courseList= listOf(
            Courses("M101","Mobile Development","Introduction to Mobile Development","John Owour"),
            Courses("P101","Back end Development","Introduction to Python","James Mwai"),
            Courses("Js101","Front end Development","Introduction to JavaScript","Purity Maina"),
            Courses("UI/UX101","UI/UX Design","Introduction to UI/UX Design","Eric Asiago")
        )

        var coursesAdapter=CoursesAdapter(courseList)
        rvcourses.layoutManager= LinearLayoutManager(baseContext)
        rvcourses.adapter=coursesAdapter
    }
}

