package com.example.rentateamtest.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.rentateamtest.R
import com.example.rentateamtest.domain.model.User

class UsersAdapter : ListAdapter<User, UserViewHolder>(diffCallback) {

    var listener: UsersAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        val result = UserViewHolder(view)
        view.setOnClickListener {
            val position = result.adapterPosition
            val item = getItem(position)
            listener?.onUserClick(item.id)
        }
        return result
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.firstName == newItem.firstName ||
                        oldItem.lastName == newItem.lastName
            }
        }
    }
}
