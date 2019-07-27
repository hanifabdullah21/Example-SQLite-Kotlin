package com.singpaulee.example_sqlite_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_student.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
    }
}
