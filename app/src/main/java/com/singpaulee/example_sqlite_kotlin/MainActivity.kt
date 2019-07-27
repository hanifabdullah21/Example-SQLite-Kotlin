package com.singpaulee.example_sqlite_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = getListDataStudent()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = StudentAdapter(this, list)

        main_rv_list_data.layoutManager = layoutManager
        main_rv_list_data.adapter = adapter

        main_cv_add_data.onClick {
            startActivity(intentFor<AddStudentActivity>())
        }
    }

    private fun getListDataStudent(): List<StudentContract> {
        var listData : List<StudentContract>? = null
        database.use {
            val result = select(StudentContract.TABLE_STUDENT)
            listData = result.parseList(classParser<StudentContract>())
        }
        return listData!!
    }
}
