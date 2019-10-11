package com.example.bubblepicker.View

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.bubblepicker.R
import kotlinx.android.synthetic.main.fragmentmenu.*

class Menu2Fragment :Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundmenu.setBackgroundColor(ContextCompat.getColor(context!!,R.color.menu2))
        tvpageid.text = "2"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmentmenu, container, false)
    }
    override fun onStart() {
        super.onStart()
        progressload.show()
        collapsibleCalendar.visibility = GONE
        bgbg.visibility = GONE

    }
    override fun onResume() {
        super.onResume()
        progressload.hide()
    }
    override fun onStop() {
        super.onStop()
        progressload.hide()
    }

    companion object{
        @JvmStatic
        fun newInstance(): Menu2Fragment {
            val bundle = Bundle()
            val fragment = Menu2Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}