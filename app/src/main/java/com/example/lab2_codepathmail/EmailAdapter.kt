package com.example.lab2_codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter {

    class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>()
    {
        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // Your holder should contain and initialize a member variable
            // for any view that will be set as you render a row
            val sender = itemView.findViewById<TextView>(R.id.sender)
            val title = itemView.findViewById<TextView>(R.id.title)
            val summary = itemView.findViewById<TextView>(R.id.summary)
        }

        // ... constructor and member variables
        // Usually involves inflating a layout from XML and returning the holder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailAdapter.ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            // Inflate the custom layout
            val contactView = inflater.inflate(R.layout.email_item, parent, false)
            // Return a new holder instance
            return ViewHolder(contactView)
        }

        // Involves populating data into the item through holder
        override fun onBindViewHolder(viewHolder: EmailAdapter.ViewHolder, position: Int) {
            // Get the data model based on position
            val email = emails.get(position)
            // Set item views based on views and data model
            viewHolder.sender.text = email.sender
            viewHolder.title.text = email.title
            viewHolder.summary.text = email.summary
        }

        // Returns the total count of items in the list
        override fun getItemCount(): Int {
            return emails.size
        }
    }
}