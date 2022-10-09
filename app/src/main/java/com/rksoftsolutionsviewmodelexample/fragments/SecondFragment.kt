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
import com.rksoftsolutionsviewmodelexample.databinding.FragmentSecondBinding
import com.rksoftsolutionsviewmodelexample.models.ColorChangeLiveData


class SecondFragment : Fragment() {
   lateinit var binding:FragmentSecondBinding
    lateinit var mainActivity: MainActivity
    lateinit var colorChangeLiveData: ColorChangeLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity= activity as MainActivity
        colorChangeLiveData= ViewModelProvider(mainActivity)[ColorChangeLiveData::class.java]
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSecondBinding.inflate(inflater, container, false)
        colorChangeLiveData.mycolor.observe(mainActivity, Observer {
            replaceColor(it)
        })
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    @SuppressLint("ResourceAsColor")
    fun replaceColor(value:Int){
            when(value){
                1->{
                    binding.secondFragment.setBackgroundColor(Color.parseColor("#FF018786"))
                }
                2->{
                    binding.secondFragment.setBackgroundColor(Color.parseColor("#FF018786"))
                }
                3->{
                    binding.secondFragment.setBackgroundColor(Color.parseColor("#ff0000"))
                }

        }
    }
}