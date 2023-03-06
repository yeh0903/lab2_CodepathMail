package com.example.lab2_codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var emails: List<Email>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.mailView)
        emails = EmailFetcher.getEmails()
        val emailAdapter = EmailAdapter.EmailAdapter(emails)
        recyclerView.adapter = emailAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.loadMoreBtn)
        button.setOnClickListener {
            val nextEmails = EmailFetcher.getNext5Emails()
            (emails as MutableList<Email>).addAll(nextEmails)
            emailAdapter.notifyDataSetChanged()
        }
    }
}