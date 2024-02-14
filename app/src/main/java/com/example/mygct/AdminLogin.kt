package com.example.mygct



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminLogin : AppCompatActivity() {

    private lateinit var adminName: EditText
    private lateinit var adminPassword: EditText
    private lateinit var adminLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        adminName = findViewById(R.id.adminname)
        adminPassword = findViewById(R.id.adminpassword)
        adminLogin = findViewById(R.id.adminlogin)

        adminLogin.setOnClickListener { adminLoggedIn() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun adminLoggedIn() {
        val adName = "Divaa"
        val adPas = "admin"

        if (adminName.text.toString() == adName && adminPassword.text.toString() == adPas) {
            val intent = Intent(this, AdminHome::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Wrong Admin Name or Password !!", Toast.LENGTH_SHORT).show()
        }
    }
}
