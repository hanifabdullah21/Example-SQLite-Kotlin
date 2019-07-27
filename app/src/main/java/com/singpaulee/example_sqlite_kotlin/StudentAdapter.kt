package com.singpaulee.example_sqlite_kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_student.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class StudentAdapter(val context: Context, val list: List<StudentContract>)
    : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    lateinit var itemview: View

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        itemview = LayoutInflater.from(context).inflate(R.layout.item_student, p0, false)
        return ViewHolder(itemview)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(list[p1])
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(studentContract: StudentContract) {
            itemView.is_tv_student_name.text = studentContract.name
            itemView.is_tv_student_age.text = studentContract.age.toString()

            itemView.onClick {
                itemView.context.startActivity(itemView.context.intentFor<DetailStudentActivity>("student" to studentContract))
            }
        }

    }

}