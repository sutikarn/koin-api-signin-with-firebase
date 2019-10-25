package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bubblepicker.MainActivity
import com.example.bubblepicker.R
import com.github.pwittchen.rxbiometric.library.validation.Preconditions
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragmentmenu3.*

class Menu3Fragment: Fragment() {

    private lateinit var auth: FirebaseAuth
    private var disposable: Disposable? = null
    private lateinit var mainActivity:MainActivity


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        mainActivity  = activity as MainActivity

        regis.setOnClickListener {
            if (username.text.toString().isEmpty()||pass.text.toString().isEmpty()){
                Toast.makeText(context,"Plase in put Username Or Password ",Toast.LENGTH_SHORT).show()
            }
            else {
                auth.createUserWithEmailAndPassword(username.text.toString(), pass.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Successfully Registered", Toast.LENGTH_LONG).show()

                        } else {
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
        signin.setOnClickListener {
            if (username.text.toString().isEmpty()||pass.text.toString().isEmpty()){
                Toast.makeText(context,"Plase in put Username Or Password ",Toast.LENGTH_SHORT).show()
            }
            else {
                auth.signInWithEmailAndPassword(username.text.toString(), pass.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Successfully Login", Toast.LENGTH_LONG).show()

                        } else {
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
        Preconditions.hasBiometricSupport(context!!)
        button.setOnClickListener {
            mainActivity!!.biometic()

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