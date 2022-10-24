package ru.pazderin.mydialer

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import ru.pazderin.mydialer.classes.Contact


class ContactDiffCallback() : ItemCallback<Contact>(){
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return  oldItem == newItem
    }

}