package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //static fragments in xml file
        //dynamic fragments


        //sending data in fragment using bundle

        val bundle=Bundle()
        bundle.putString("KEY","Increase the count")

        val bundle1=Bundle()
        bundle1.putString("KEY","Decrease the count")
        val countUp=CountUp()
            countUp.arguments=bundle

        val countDown=count_Down()
            countDown.arguments=bundle1

//dynamic fragments and sending data using bundle
//        btn1.setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragContainer,countUp)
//                .commit()
//        }
//
//        btn2.setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragContainer,countDown)
//                .commit()
//        }


        //viewpager and bundle
        val viewPagerAdapter =viewPageAdapter(supportFragmentManager)
        viewPagerAdapter.apply {
            add(countUp)
            add(countDown)
        }
        viewPager.adapter=viewPagerAdapter
        viewPager.setPageTransformer(true,ZoomOutPageTransformer())
    }
}