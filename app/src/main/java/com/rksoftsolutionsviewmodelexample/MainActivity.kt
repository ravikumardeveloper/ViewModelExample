package com.rksoftsolutionsviewmodelexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rksoftsolutionsviewmodelexample.databinding.ActivityMainBinding
import com.rksoftsolutionsviewmodelexample.models.ColorChangeLiveData

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var colorChangeLiveData:ColorChangeLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        colorChangeLiveData=ViewModelProvider(this)[ColorChangeLiveData::class.java]

        binding.btnPurple.setOnClickListener {
          colorChangeLiveData.mycolor.value=1
        }
        binding.btnRed.setOnClickListener {
            colorChangeLiveData.mycolor.value=2
        }
        binding.btnGreen.setOnClickListener {
            colorChangeLiveData.mycolor.value=3
        }

    }
}