package com.example.bubblepicker.Api

import android.content.Context
import com.example.bubblepicker.MockJsonStatus
import okhttp3.*

class OkHttpMockInterceptor(private val context: Context) :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var path = chain.request().url().encodedPath()
        path = path.substring(1)
        return when (MockJsonStatus().getmockdata(path)){
            true -> getitem(chain,path)
            else -> chain.proceed(chain.request())
        }
    }

    private fun getitem(chain: Interceptor.Chain, path: String): Response {
        val json = context.assets.open(path).bufferedReader().use { it.readText() }
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .body(ResponseBody.create(MediaType.parse("application/json"), json))
            .addHeader("content-type", "application/json")
            .build()
    }
}