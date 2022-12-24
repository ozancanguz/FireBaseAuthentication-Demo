package com.ozancanguz.firebaseauthentication.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.firebaseauthentication.R
import com.ozancanguz.firebaseauthentication.databinding.FragmentLoginBinding
import com.ozancanguz.firebaseauthentication.databinding.FragmentUserDetailsBinding


class UserDetailsFragment : Fragment() {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        FirebaseApp.initializeApp(requireContext())
        // Initialize Firebase Auth
        auth = Firebase.auth

        setHasOptionsMenu(true)



        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.signoutmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.signOutMenu){
            findNavController().navigate(R.id.action_userDetailsFragment_to_loginFragment)
            auth.signOut()
        }

        return super.onOptionsItemSelected(item)
    }

}