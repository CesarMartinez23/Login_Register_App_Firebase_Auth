package com.example.loginandregisterapp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context : Activity, private val arrayList: ArrayList<Contact>) : ArrayAdapter<Contact>(context, R.layout.list_item, arrayList) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.list_item, null)

        val contact_image = view.findViewById<ImageView>(R.id.contact_image)
        val contact_name = view.findViewById<TextView>(R.id.contact_name)
        val contact_nationality = view.findViewById<TextView>(R.id.contact_nationality)

        contact_image.setImageResource(arrayList[position].imageId)
        contact_name.text = arrayList[position].fullName
        contact_nationality.text = arrayList[position].nationality

        return view
    }
}