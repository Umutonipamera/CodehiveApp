package com.example.codehiveapp.ui
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehiveapp.CoursesAdapter
import java.util.prefs.AbstractPreferences


class Course : AppCompatActivity() {
    lateinit var binding: ActivityCourseBinding
    lateinit var sharedPreferences: sharedPreferences
    val courseViewModel:CourseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseRespponseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences(Constants.SHAREDPREFERENCE,Context.MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        var accessToken=sharedPreferences.getString(Constants.toString(),"ACCESS_TOKEN")
        var bearer="Bearer $accessToken"
        if(accessToken!!.isNotEmpty()){
            courseViewModel.getCourses(bearer)
        }
        else{
            startActivity(Intent(baseContext,LoginActivity::class.java))
        }

        var rvCourseResponse = binding.rvCourseResponse
        rvCourseResponse.layoutManage=LinearLayoutManager(baseContext)
        courseViewModel.courseLiveData.observe(this, { courseResponse ->
            var coursesResponseAdapter=CoursesResponseAdapter(coursesResponse)
            rvCourseResponse.adapter=coursesResponseAdapter

        })

        courseViewModel.courseLiveData.observe(this, { CourseResponse ->
            var coursesAdapter = CoursesAdapter(courseResponse)
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = coursesAdapter
        })
        courseViewModel.courseFailedLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
        courseViewModel.getCourses(accessToken)
    }
    }




