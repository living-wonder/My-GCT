package com.example.mygct



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var admin: ImageView
    private lateinit var student: ImageView
    private lateinit var tpo: ImageView
    private lateinit var settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        admin = findViewById(R.id.admin)
        student = findViewById(R.id.student)
        tpo = findViewById(R.id.tpo)
        settings = findViewById(R.id.settings)

        admin.setOnClickListener{
            adminClicked()
        }
        student.setOnClickListener{
            studentClicked()
        }
        tpo.setOnClickListener{
            tpoClicked()
        }
    }

    fun adminClicked() {
        val intent = Intent(this, AdminLogin::class.java)
        startActivity(intent)
    }

    fun tpoClicked() {
        val intent = Intent(this, TPOLogin::class.java)
        startActivity(intent)
    }

    fun studentClicked() {
        val intent = Intent(this, StudentLogin::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        System.exit(0)
    }

    fun logoutTPO(view: View) {
        // Handle logout TPO action if needed
    }
}
