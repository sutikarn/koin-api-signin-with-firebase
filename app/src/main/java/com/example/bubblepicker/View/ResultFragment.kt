package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bubblepicker.Adapter.ListItemByPageAdapter
import com.example.bubblepicker.Model.ListItemResponse
import com.example.bubblepicker.R
import com.example.bubblepicker.Room.AppDatabase
import com.example.bubblepicker.Room.FavEntity
import com.example.bubblepicker.ViewModel.LuckyViewModel
import kotlinx.android.synthetic.main.resultfragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class ResultFragment(var page: String) :Fragment(){
    private val luckyViewModel: LuckyViewModel by viewModel()

    private val adapter by lazy { ListItemByPageAdapter(context)
    {   model, action ->
        val item = model as ListItemResponse
        when(action){

            "click"-> {
                Toast.makeText(context,item.name,Toast.LENGTH_SHORT).show()
                fragmentManager!!.beginTransaction().replace(R.id.fragmentContainer,DetailItemFragment.newInstance(item.name)).addToBackStack("result").commit()
                }


            "fav" -> {
                val appDatabase = AppDatabase.getAppDatabase(context!!)
                var fav =FavEntity()
                fav.name = item.name
                fav.status = true.toString()
                if (appDatabase.favdao().getStudentByName(item.name).isNotEmpty()){
                    appDatabase.favdao().deletefav(item.name)
                }
                else{
                    appDatabase.favdao().insertFav(fav)
                }
            }

        }
    }}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.resultfragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        progressload.show()
        luckyViewModel.getItemRo(page)
        luckyViewModel.listItemRo.observe(this, Observer(function = fun(it: List<ListItemResponse>) {
            it.let {
                progressload.hide()
                adapter.addListItem(it)
                rvlistitembypage.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                rvlistitembypage.adapter = adapter
            }
        }))

    }


    companion object{
        @JvmStatic
        fun newInstance(page:String): ResultFragment {
            val bundle = Bundle()
            val fragment = ResultFragment(page)
            fragment.arguments = bundle
            return fragment
        }
    }
}