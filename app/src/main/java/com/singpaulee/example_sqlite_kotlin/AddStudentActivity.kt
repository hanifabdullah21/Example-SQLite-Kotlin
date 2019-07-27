package com.singpaulee.example_sqlite_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_student.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class AddStudentActivity : AppCompatActivity() {
    //TODO Buat dan atur kelas AddStudentActivity buat fungsi : validasi dan insertDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)


        asa_tv_choose_study.onClick {
            val jurusan = listOf("IPA","IPS","Bahasa")
            selector("Pilih jurusan",jurusan) { dialog, i ->
                asa_tv_major.setText(jurusan[i])
            }
        }

        asa_btn_save.onClick {
            if (!validation()){
                return@onClick
            }
            insertDatabase()
        }
    }

    private fun insertDatabase() {
        database.use {
            insert(StudentContract.TABLE_STUDENT,
                StudentContract.NAME to asa_edt_name.text.toString(),
                StudentContract.AGE to asa_edt_age.text.toString().toInt(),
                StudentContract.ADDRESS to asa_edt_address.text.toString(),
                StudentContract.PHOTO to null,
                StudentContract.MAJORITY to asa_tv_major.text.toString()
            )

            toast("Berhasil menambah data siswa baru")
        }
    }

    private fun validation(): Boolean{
        when {
            asa_edt_name.text.toString().isBlank() -> {
                asa_edt_name.requestFocus()
                asa_edt_name.error = "Tidak boleh kosong"
                return false
            }
            asa_edt_age.text.toString().isBlank() -> {
                asa_edt_age.requestFocus()
                asa_edt_age.error = "Tidak boleh kosong"
                return false
            }
            asa_edt_address.text.toString().isBlank() -> {
                asa_edt_address.requestFocus()
                asa_edt_address.error = "Tidak boleh kosong"
                return false
            }
            asa_tv_major.text.toString().isBlank() -> {
                asa_tv_major.requestFocus()
                asa_tv_major.error = "Tidak boleh kosong"
                return false
            }
            else -> return true
        }

    }
}
