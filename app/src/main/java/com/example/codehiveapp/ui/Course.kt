package com.example.codehiveapp.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehiveapp.CoursesAdapter



class Course : AppCompatActivity() {
    lateinit var binding: ActivityCourseBinding
    val courseViewModel:CoursesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourse.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        courseViewModel.courses()
        var rvCourses = binding.rvCourses
        courseViewModel.courseLiveData.observe(this, { CourseResponse ->
            var coursesAdapter = CoursesAdapter(courseResponse)
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = coursesAdapter
        })
    }
    }




