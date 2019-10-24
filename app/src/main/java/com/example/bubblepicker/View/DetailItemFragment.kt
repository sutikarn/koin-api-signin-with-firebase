package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bubblepicker.R
import kotlinx.android.synthetic.main.detailitem.*

class DetailItemFragment :Fragment() {

    var name:String =""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null){
            tvname.text = arguments!!.getString("name","eee")
        }
        else {
            tvname.text = savedInstanceState.getString("name","")
        }


        tagdetail.setTags("a","b","c")
        tagdetail.setOnTagClickListener {
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()

        }



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detailitem, container, false)

    }

    companion object{
        @JvmStatic
        fun newInstance(name: String): DetailItemFragment {
            val bundle = Bundle()
            bundle.putString("name",name)
            val fragment = DetailItemFragment()
             fragment.arguments = bundle
            return fragment
        }
    }
}