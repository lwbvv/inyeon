package com.example.inyeon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.inyeon.viewPager.HomeViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_page.*

class FragmentHome : Fragment() {

    lateinit var viewPager: ViewPager
    lateinit var homeViewPagerAdapter: HomeViewPagerAdapter
        lateinit var tabLayout: TabLayout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: ViewGroup = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup
        viewPager = rootView.findViewById(R.id.home_viewPager)
//        tabLayout = home_viewPager_tab
        homeViewPagerAdapter = HomeViewPagerAdapter(container!!.context)
        viewPager.adapter = homeViewPagerAdapter
        tabLayout = rootView.findViewById(R.id.home_viewPager_tab)
        tabLayout.setupWithViewPager(viewPager, true)
        /**
         *  뷰페이저 다음 뷰도 약간 보일 수 있게 마진 설정
         */
        viewPager.clipToPadding = false
        viewPager.setPadding(0,0,100,0)
        viewPager.pageMargin = 50


//        tabLayout.setupWithViewPager(viewPager, true)


        return rootView
    }
}