package com.ozancanguz.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.firebaseauthentication.R
import com.ozancanguz.firebaseauthentication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        FirebaseApp.initializeApp(requireContext())
        // Initialize Firebase Auth
        auth = Firebase.auth

        register()
        signIn()



        return view
    }

    private fun signIn() {
       binding.signInBtn.setOnClickListener {
           val email=binding.emailET.text.toString()
           val password=binding.passwordET.text.toString()

           auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
               findNavController().navigate(R.id.action_loginFragment_to_userDetailsFragment)
           }.addOnFailureListener {
               Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
           }

       }
    }


    private fun register() {

          binding.registerBtn.setOnClickListener {
              val email=binding.emailET.text.toString()
              val password=binding.passwordET.text.toString()
                  auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                      findNavController().navigate(R.id.action_loginFragment_to_userDetailsFragment)
                  }.addOnFailureListener {
                      Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
                  }


          }
    }


}