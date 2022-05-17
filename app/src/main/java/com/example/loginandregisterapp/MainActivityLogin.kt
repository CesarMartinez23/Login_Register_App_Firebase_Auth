package com.example.loginandregisterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_login.*

class MainActivityLogin : AppCompatActivity() {

    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        firebaseAuth = FirebaseAuth.getInstance()

        txt_register.setOnClickListener {
            goToRegisterActivity()
        }

        btn_login.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = getEmail()
        val password = getPassword()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "User found", Toast.LENGTH_SHORT).show()
                    goToHomeActivity()
                } else {
                    Toast.makeText(this, "User not found, please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        }else {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToHomeActivity() {
        val intent = Intent(this, MainActivityHomeUser::class.java)
        startActivity(intent)
    }

    private fun goToRegisterActivity(){
        val intent = Intent(this, MainActivityRegister::class.java)
        startActivity(intent)
    }
    private fun getEmail(): String {
        return edt_email_address.text.toString()
    }

    private fun getPassword(): String {
        return edt_password.text.toString()
    }
}