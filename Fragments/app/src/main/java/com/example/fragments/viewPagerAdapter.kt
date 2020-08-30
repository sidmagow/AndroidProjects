package com.example.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class viewPageAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {
    val list = arrayListOf<Fragment>()

    fun add(frag:Fragment){
        list.add(frag)
    }
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

}