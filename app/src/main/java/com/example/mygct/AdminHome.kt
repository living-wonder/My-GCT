package com.example.mygct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminHome : AppCompatActivity() {

    private lateinit var addTpoBtn: Button
    private lateinit var addStudentBtn: Button
    private lateinit var logoutBtn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        addTpoBtn = findViewById(R.id.addtpobtn)
        addStudentBtn = findViewById(R.id.addstudentbtn)
        logoutBtn=findViewById(R.id.logoutbtn)


        addTpoBtn.setOnClickListener { addTpo() }
        addStudentBtn.setOnClickListener { addStudent() }
        logoutBtn.setOnClickListener { logoutAdmin() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addTpo() {
       val intent = Intent(this, AddingNewTPO::class.java)
        startActivity(intent)
    }

    private fun addStudent() {
        val intent = Intent(this, AddingNewStudent::class.java)
        startActivity(intent)
    }

    fun logoutAdmin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
