package com.example.bubblepicker

class MockJsonStatus {

    fun getmockdata(namedata:String): Boolean? {

        var listjson = mapOf(
            "listlucky" to true
            ,"api" to false)

        return listjson[namedata]

    }
}