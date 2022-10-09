package com.rksoftsolutionsviewmodelexample.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorChangeLiveData: ViewModel() {
    var mycolor: MutableLiveData<Int> = MutableLiveData(0)
}