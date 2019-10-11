package com.example.bubblepicker.Api

import com.example.bubblepicker.Model.ListItemResponse
import com.example.bubblepicker.Model.ListLucky
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface LuckyApi {

    @GET("listlucky")
    fun getItem(): Observable<ListLucky>

    @GET("api")
    fun getItemRo(@Query("page")page:String):Observable<List<ListItemResponse>>

    @GET("status")
    fun getItemByStatus(@Query("status")status:String):Observable<List<ListItemResponse>>

    @GET("id")
    fun getItemById(@Query("id")id:String ,@Query("page")page:String):Observable<List<ListItemResponse>>


}