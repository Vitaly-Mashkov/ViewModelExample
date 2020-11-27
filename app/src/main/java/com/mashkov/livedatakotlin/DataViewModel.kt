package com.mashkov.livedatakotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val data: MutableLiveData<String> = MutableLiveData()
    private val dataRepository = DataRepository()

    fun getData(): LiveData<String> {
        loadData()
        return data
    }

    private fun loadData() {
        dataRepository.loadData(object : OnLoadListener {
            override fun onLoadData(data: String?) {
                this@DataViewModel.data.postValue(data)
            }
        })
    }
}