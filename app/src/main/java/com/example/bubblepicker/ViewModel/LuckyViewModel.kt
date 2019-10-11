package com.example.bubblepicker.ViewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bubblepicker.Api.LuckyApi
import com.example.bubblepicker.Model.ListItemResponse
import com.example.bubblepicker.Model.ListLucky
import com.example.bubblepicker.View.Menu4Fragment
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.standalone.KoinComponent


class LuckyViewModel(private val luckyApi: LuckyApi):ViewModel(), KoinComponent {

    var listItem = MutableLiveData<ListLucky>()
    var errorMessage = MutableLiveData<String>()
    var listItemRo = MutableLiveData<List<ListItemResponse>>()

    @SuppressLint("CheckResult")
    fun getItem(){
        luckyApi.getItem()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({ data ->
               listItem.value = data
           }, { error ->
               errorMessage.value = error.localizedMessage
           })
    }

    @SuppressLint("CheckResult")
    fun getItemRo(page: String) {
        luckyApi.getItemRo(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                listItemRo.value = data
            }, { error ->
                errorMessage.value = error.localizedMessage
            })
    }

    @SuppressLint("CheckResult")
    fun getItemByStatus(status:String){
        luckyApi.getItemByStatus(status)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({data ->
                listItemRo.value = data
            },{  error ->
                errorMessage.value = error.localizedMessage

            })
    }

    @SuppressLint("CheckResult")
    fun getItemById(id:String){
        luckyApi.getItemById(id,id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({data ->
                listItemRo.value =data
            },{  error ->
                errorMessage.value = error.localizedMessage
            })
    }
}