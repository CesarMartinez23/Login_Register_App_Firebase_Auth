package com.example.loginandregisterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_register.*

class MainActivityRegister : AppCompatActivity() {

    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        firebaseAuth = FirebaseAuth.getInstance()

        txt_login_register.setOnClickListener {
            goToLoginActivity()
        }

        btn_register.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val email = getEmail()
        val password = getPassword()
        val confirmPassword = getConfirmPassword()

        if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password == confirmPassword) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                        goToLoginActivity()
                    } else {
                        Toast.makeText(this, "User not created", Toast.LENGTH_SHORT).show()
                    }
                }
            }else {
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, MainActivityLogin::class.java)
        startActivity(intent)
    }

    private fun getEmail(): String {
        return edt_email_address.text.toString()
    }

    private fun getPassword(): String {
        return edt_password.text.toString()
    }

    private fun getConfirmPassword(): String {
        return edt_password.text.toString()
    }
}