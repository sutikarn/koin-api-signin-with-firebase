package com.example.bubblepicker.pref

import com.mohamadamin.kpreferences.preference.Preference


class PrefUtils {

    var isLogin: Boolean by Preference(false, "isLogin")
    var count:Int by Preference(0)

    companion object {
        val instance: PrefUtils by lazy { PrefUtils() }
    }
}
