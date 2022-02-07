package com.example.telegram_contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram_contacts.adapter.ContactAdapter
import com.example.telegram_contacts.model.Contact

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        refreshAdapter(getContacts())
    }

    private fun refreshAdapter(contacts: ArrayList<Contact>) {
            val adapter = ContactAdapter(this, contacts)
            recyclerView.adapter = adapter
    }

    private fun getContacts(): ArrayList<Contact> {
        var contacts:ArrayList<Contact> = ArrayList()

        for (i in 0..12){
            contacts.add(Contact("Tohir Rahmatullayev",R.drawable.tohir,"Last seen at 23:45"))
            contacts.add(Contact("Sarvar Khalmatov",R.drawable.sarvar,"Been long time ago"))
            contacts.add(Contact("Tohir Rahmatullayev",R.drawable.tohir,"Online"))
            contacts.add(Contact("Sherzod Jo`rabekov",R.drawable.sherzod,"Last seen just now"))
            contacts.add(Contact("Sarvar Khalmatov",R.drawable.sarvar,"Last seen a week ago"))
            contacts.add(Contact("Sherzod Jo`rabekov",R.drawable.sherzod,"Online"))
        }
        return contacts
    }
}