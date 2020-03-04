package com.example.bubblepicker.View

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bubblepicker.MainActivity
import com.example.bubblepicker.R
import com.google.firebase.auth.FirebaseAuth
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragmentmenu3.*

class Menu3Fragment: Fragment() {

    private lateinit var auth: FirebaseAuth
    private var disposable: Disposable? = null
    private lateinit var mainActivity:MainActivity
    private val rxPermission by lazy { RxPermissions(activity as Activity) }


    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        mainActivity  = activity as MainActivity
        rxPermission.request(
            Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION).subscribe {
            if (it){

        }
            else {
            rxPermission.request(
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        }


        regis.setOnClickListener {
            if (username.text.toString().isEmpty()||pass.text.toString().isEmpty()){
                Toast.makeText(context,"Please in put Username Or Password ",Toast.LENGTH_SHORT).show()
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
                Toast.makeText(context,"Please in put Username Or Password ",Toast.LENGTH_SHORT).show()
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

        button.setOnClickListener {
            mainActivity.biometic()

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