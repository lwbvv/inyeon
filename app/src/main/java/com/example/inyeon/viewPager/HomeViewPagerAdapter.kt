package com.example.inyeon.viewPager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.inyeon.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeViewPagerAdapter : PagerAdapter{


    private lateinit var context : Context

    constructor() : super()
    constructor(context: Context) : super() {
        this.context = context
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
       var view : View ? = null

        var inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater //
        view = inflater.inflate(R.layout.home_page, container, false)
        Log.e("viewpager", "instantiateItem")
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        Log.e("viewpager", "isViewFromObject")
        return (view == `object` as View)
    }

    override fun getCount(): Int {//터치 입력을 받으면 실시간으로 카운트를 계속 측정한다
        Log.e("viewpager", "getCount")
        return 10
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.e("viewpager", "destroyItem")
        container.removeView(`object` as View)
    }


}