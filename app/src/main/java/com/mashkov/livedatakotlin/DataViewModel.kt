package com.mashkov.livedatakotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private var data: MutableLiveData<String>? = null
    private val dataRepository = DataRepository()
    fun getData(): LiveData<String> {
        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data as MutableLiveData<String>
    }

    private fun loadData() {
        dataRepository.loadData(object : OnLoadListener {
            override fun onLoadData(data: String?) {
                this@DataViewModel.data?.postValue(data)
            }
        })
    }
}