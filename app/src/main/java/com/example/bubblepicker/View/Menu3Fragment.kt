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
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import kotlinx.android.synthetic.main.fragmentmenu.*

class Menu3Fragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundmenu.setBackgroundColor(ContextCompat.getColor(context!!,R.color.menu3))
        tvpageid.text = "3"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmentmenu3, container, false)
    }

    override fun onStart() {
        super.onStart()
        progressload.show()
        collapsibleCalendar.visibility = GONE
        bgbg.visibility = GONE
    }

    override fun onStop() {
        super.onStop()
        progressload.hide()
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