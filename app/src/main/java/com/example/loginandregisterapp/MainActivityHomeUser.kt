package com.example.loginandregisterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_home_user.*

class MainActivityHomeUser : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private var contactArrayList: ArrayList<Contact> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home_user)

        firebaseAuth = FirebaseAuth.getInstance()

        contactArrayList = ArrayList()
        for (i in setName().indices) {
            val contact = Contact(setName()[i], setNationality()[i], setImage()[i])
            contactArrayList.add(contact)
        }
        listView.adapter = MyAdapter(this, contactArrayList)

        btn_logOut.setOnClickListener {
            logOut()
        }
    }

    private fun logOut() {
        firebaseAuth.signOut()
        goToLogin()
        finish()
    }

    private fun goToLogin() {
        val intent = Intent(this, MainActivityLogin::class.java)
        startActivity(intent)
    }

    fun setImage(): IntArray {
        val imgId = intArrayOf(
            R.drawable.yosselin,
            R.drawable.cesar
        )
        return imgId
    }

    fun setName(): Array<String> {
        val fullName = arrayOf(
            "Yosselin",
            "Cesar"
        )
        return fullName
    }

    fun setNationality(): Array<String> {
        val nationality = arrayOf(
            "El Salvador",
            "El Salvador"
        )
        return nationality
    }
}