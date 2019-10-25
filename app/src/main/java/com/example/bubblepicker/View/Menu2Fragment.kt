package com.example.bubblepicker.View

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bubblepicker.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment2.*
import kotlinx.android.synthetic.main.fragmentmenu.*
import com.hitomi.cmlibrary.OnMenuStatusChangeListener
import com.hitomi.cmlibrary.OnMenuSelectedListener




class Menu2Fragment :Fragment() {

    @SuppressLint("PrivateResource")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        Picasso.with(context)
            .load(R.drawable.chile)
            .placeholder(R.drawable.menu1)
            .transform(CropCircleTransformation())
            .into(imagepicasso)

        Glide.with(context!!)
            .load(R.drawable.argentina)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.menu1)
            .into(glideimage)

        circle_menu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha)
            .addSubMenu(Color.parseColor("#000000"), R.drawable.menu1)
            .addSubMenu(Color.parseColor("#000000"), R.drawable.menu2)
            .addSubMenu(Color.parseColor("#000000"), R.drawable.menu3)
            .addSubMenu(Color.parseColor("#000000"), R.drawable.menu4)
            .setOnMenuSelectedListener {
                Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()
            }
            .setOnMenuStatusChangeListener(object : OnMenuStatusChangeListener {

                override fun onMenuOpened() {}

                override fun onMenuClosed() {}

            })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
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