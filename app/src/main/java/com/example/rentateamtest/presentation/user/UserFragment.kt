package com.example.rentateamtest.presentation.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.rentateamtest.databinding.FragmentUserBinding
import com.example.rentateamtest.domain.model.User
import com.example.rentateamtest.presentation.common.BaseFragment
import com.example.rentateamtest.utils.appComponent
import com.example.rentateamtest.utils.load
import javax.inject.Inject

class UserFragment : BaseFragment<FragmentUserBinding>(
    FragmentUserBinding::inflate,
) {

    @Inject
    lateinit var viewModelFactory: UserViewModelFactory

    private val viewModel: UserViewModel by viewModels {
        viewModelFactory
    }

    private val args: UserFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext().appComponent.inject(this)
        viewModel.user.observe(viewLifecycleOwner, ::show)
        viewModel.getUser(args.id)
    }

    private fun show(user: User) = with(binding) {
        if (user.avatarUrl.isNotEmpty()) {
            userAvatar.load(user.avatarUrl)
        }
        name.text = user.firstName
        lastName.text = user.lastName
        email.text = user.email
    }
}
