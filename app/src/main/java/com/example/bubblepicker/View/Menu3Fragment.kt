package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bubblepicker.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragmentmenu3.*

class Menu3Fragment: Fragment() {

    private lateinit var auth: FirebaseAuth



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        regis.setOnClickListener {
            auth.createUserWithEmailAndPassword(username.text.toString(), pass.text.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Successfully Registered", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show()
                }
            }
        }
        signin.setOnClickListener {
            auth.signInWithEmailAndPassword(username.text.toString(), pass.text.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Successfully Login", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show()
                }
            }
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmentmenu3, container, false)
    }


    companion object{
        @JvmStatic
        fun newInstance(): Menu3Fragment {
            val bundle = Bundle()
            val fragment = Menu3Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}