package com.example.bubblepicker.View

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bubblepicker.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment2.*
import kotlinx.android.synthetic.main.fragmentmenu.*

class Menu2Fragment :Fragment() {

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