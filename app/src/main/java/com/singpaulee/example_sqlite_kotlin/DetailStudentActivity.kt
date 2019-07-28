package com.singpaulee.example_sqlite_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_detail_student.*
import org.jetbrains.anko.db.delete

class DetailStudentActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var student: StudentContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)
        
        student = intent.getParcelableExtra<StudentContract>("student")
        Log.d("STUDENT", student.toString())

        dsa_tv_name.text = student.name
        dsa_tv_age.text = "${student.age} tahun"
        dsa_tv_address.text = student.address
        dsa_tv_major.text = student.majority

        dsa_btn_delete.setOnClickListener(this)
        dsa_btn_update.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            dsa_btn_delete -> deleteData(student.id)
        }
    }

    private fun deleteData(id: Long?) {
        database.use {
            delete(StudentContract.TABLE_STUDENT, "${StudentContract.ID} = {id}", "id" to id!!.toInt())
        }
        finish()
    }


}
