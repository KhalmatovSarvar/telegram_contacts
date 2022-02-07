package com.example.telegram_contacts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram_contacts.R
import com.example.telegram_contacts.model.Contact
import com.google.android.material.imageview.ShapeableImageView

class ContactAdapter(var context: Context,var contacts:ArrayList<Contact>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_FIRST = 0
    private val TYPE_ITEM_SECOND = 1
    private val  TYPE_CONTACT= 2

    private fun isSecondItem(position: Int): Boolean {
        return position == 1
    }

    private fun isFirstItem(position: Int): Boolean {
        return position == 0
    }

    private fun isContact(position: Int): Boolean {
        return position == 2
    }

    override fun getItemViewType(position: Int): Int {
        if (isFirstItem(position)) {
            return TYPE_ITEM_FIRST
        }
        if (isSecondItem(position)) {
            return TYPE_ITEM_SECOND
        }
            return TYPE_CONTACT

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_FIRST) {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_view_first, parent, false)
            return FirstViewHolder(view)
        } else if (viewType == TYPE_ITEM_SECOND) {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_second, parent, false)
            return SecondViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_contacts, parent, false)
            return ContactViewHolder(view)
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contacts[position]

        if (holder is ContactViewHolder){
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var tv_message = holder.tv_message

            iv_profile.setImageResource(contact.profile)
            tv_fullname.text = contact.fullname
            tv_message.text = contact.message
        }
    }

    override fun getItemCount(): Int {
    return contacts.size
    }
}





class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile:ShapeableImageView
        var tv_fullname: TextView
        var tv_message: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.fullname)
            tv_message = view.findViewById(R.id.message)
        }
}

class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {


}

class FirstViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
