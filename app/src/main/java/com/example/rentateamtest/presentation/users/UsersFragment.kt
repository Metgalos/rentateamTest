package com.example.rentateamtest.presentation.users

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentateamtest.databinding.FragmentUsersBinding
import com.example.rentateamtest.presentation.common.BaseFragment
import com.example.rentateamtest.presentation.users.adapter.UsersAdapter
import com.example.rentateamtest.presentation.users.adapter.UsersAdapterListener
import com.example.rentateamtest.utils.appComponent
import javax.inject.Inject

class UsersFragment : BaseFragment<FragmentUsersBinding>(
    FragmentUsersBinding::inflate,
) {

    @Inject
    lateinit var viewModelFactory: UsersViewModelFactory

    private val viewModel: UsersViewModel by viewModels {
        viewModelFactory
    }

    private val adapterListener by lazy {
        object : UsersAdapterListener {
            override fun onUserClick(id: Int) {
                findNavController().navigate(
                    UsersFragmentDirections.actionUsersFragmentToUserFragment(id)
                )
            }
        }
    }

    private val usersAdapter by lazy {
        UsersAdapter().apply {
            listener = adapterListener
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext().appComponent.inject(this)
        with(binding.usersList) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usersAdapter
        }
        viewModel.state.observe(viewLifecycleOwner) {
            show(it)
        }
    }

    private fun show(state: UsersState) = with(binding) {
        progressBar.isVisible = state.isLoading

        if (state.error != null) {
            error.text = state.error
        }
        error.isVisible = state.error != null

        if (state.users != null) {
            usersAdapter.submitList(state.users)
        }
        usersList.isVisible = state.users != null
    }
}

