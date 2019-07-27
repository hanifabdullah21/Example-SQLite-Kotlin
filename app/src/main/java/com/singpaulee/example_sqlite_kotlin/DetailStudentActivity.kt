package com.singpaulee.example_sqlite_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail_student.*

class DetailStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)
        
        val student = intent.getParcelableExtra<StudentContract>("student")
        Log.d("STUDENT", student.toString())

        dsa_tv_name.text = student.name
        dsa_tv_age.text = "${student.age} tahun"
        dsa_tv_address.text = student.address
        dsa_tv_major.text = student.majority
    }
}
