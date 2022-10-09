package com.rksoftsolutionsviewmodelexample.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rksoftsolutionsviewmodelexample.MainActivity
import com.rksoftsolutionsviewmodelexample.R
import com.rksoftsolutionsviewmodelexample.databinding.FragmentFirstBinding
import com.rksoftsolutionsviewmodelexample.models.ColorChangeLiveData


class FirstFragment : Fragment() {
 lateinit var binding:FragmentFirstBinding
 lateinit var mainActivity: MainActivity
 lateinit var colorChangeLiveData: ColorChangeLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity= activity as MainActivity
        colorChangeLiveData=ViewModelProvider(mainActivity)[ColorChangeLiveData::class.java]
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFirstBinding.inflate(inflater, container, false)
        colorChangeLiveData.mycolor.observe(mainActivity, Observer {
            replaceColor(it)
        })

        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


    fun replaceColor(value:Int){
        when(value){
            1->{
                binding.firstfragment.setBackgroundColor(Color.parseColor("#FF6200EE"))
            }
            2->{
                binding.firstfragment.setBackgroundColor(Color.parseColor("#ff0000"))
            }
            3->{
                binding.firstfragment.setBackgroundColor(Color.parseColor("#FF018786"))
            }

        }
    }
}