package com.example.bubblepicker.Model

import com.google.gson.annotations.SerializedName

data class ListLucky(

     @SerializedName("totalwin")
     val totalwin:String ="",
     @SerializedName("totallose")
     val totallost:String="",
     @SerializedName("totalcoin")
     val totalcoin:String ="")