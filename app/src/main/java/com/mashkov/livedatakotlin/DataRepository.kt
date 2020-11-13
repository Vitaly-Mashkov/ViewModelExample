package com.mashkov.livedatakotlin

import android.os.Handler
import android.os.Looper

class DataRepository {
    fun loadData(onLoadListener: OnLoadListener) {
        Handler(Looper.getMainLooper()).postDelayed(
            { onLoadListener.onLoadData("some random string") },
            3000
        )
    }
}