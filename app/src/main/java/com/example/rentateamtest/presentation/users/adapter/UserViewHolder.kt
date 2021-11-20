package com.example.rentateamtest.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rentateamtest.databinding.ItemUserBinding
import com.example.rentateamtest.domain.model.User

class UserViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUserBinding.bind(itemView)

    fun bind(user: User) = with(binding) {
        name.text = user.firstName
        lastName.text = user.lastName
    }
}