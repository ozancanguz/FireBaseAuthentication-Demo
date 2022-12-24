package com.ozancanguz.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.firebaseauthentication.R
import com.ozancanguz.firebaseauthentication.databinding.FragmentLoginBinding
import com.ozancanguz.firebaseauthentication.databinding.FragmentUserDetailsBinding


class UserDetailsFragment : Fragment() {
    private var _binding: FragmentUserDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}