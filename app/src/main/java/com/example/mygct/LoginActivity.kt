package com.example.mygct

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : AppCompatActivity() {
    private lateinit var signIn:Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mGoogleSignIn:GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
     mAuth = FirebaseAuth.getInstance()
        signIn = findViewById<Button>(R.id.btn_signin)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Corrected
            .requestEmail()
            .build()
        mGoogleSignIn = GoogleSignIn.getClient(this,gso)

        signIn.setOnClickListener {
            googleSignin()

        }

        
    }
    private fun googleSignin(){
        val signInClient = mGoogleSignIn.signInIntent
        launcher.launch(signInClient)

    }
private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    result->
    if(result.resultCode == Activity.RESULT_OK){
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        manageResults(task)
    }

}
private fun manageResults(task : Task<GoogleSignInAccount>){
     val account :GoogleSignInAccount?=task.result
    if(account != null){
        val crenditial =GoogleAuthProvider.getCredential(account.idToken,"")
        mAuth.signInWithCredential(crenditial).addOnCompleteListener{
            if(task.isSuccessful){
                val intent = Intent(this ,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

}
