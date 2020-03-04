package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bubblepicker.OnSwipeTouchListener
import com.example.bubblepicker.R
import com.example.bubblepicker.ViewModel.LuckyViewModel
import com.example.bubblepicker.pref.PrefUtils
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import kotlinx.android.synthetic.main.fragmentmenu.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class Menu1Fragment :Fragment(), OnMapReadyCallback {


    private val luckyViewModel: LuckyViewModel by viewModel()
    private var statusdate :Boolean?=false
    val pref: PrefUtils by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref.isLogin = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundmenu.setBackgroundColor(ContextCompat.getColor(context!!, R.color.menu1))
        pref.isLogin
        pref.count
        bgbg.setOnTouchListener(object :OnSwipeTouchListener(context){

            override fun onSwipeRight() {
                if (statusdate!!){
                    collapsibleCalendar.prevMonth()
                }
                else {
                    collapsibleCalendar.prevWeek()
                }

            }

            override fun onSwipeLeft() {
                if (statusdate!!){
                    collapsibleCalendar.nextMonth()
                }
                else {
                    collapsibleCalendar.nextWeek()
                }


            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                statusdate = true
                collapsibleCalendar.expand(400)
            }

            override fun onSwipeTop() {
                super.onSwipeTop()
                statusdate = false
                collapsibleCalendar.collapse(400)
            }

        })
        tvpageid.text = "1"
        collapsibleCalendar.setCalendarListener(object:CollapsibleCalendar.CalendarListener{
            override fun onMonthChange() {
            }

            override fun onDataUpdate() {
            }

            override fun onWeekChange(position: Int) {
            }

            override fun onDaySelect() {

                var day = collapsibleCalendar.selectedDay.day.toString()+" "
                var month = collapsibleCalendar.selectedDay.month.toString()+" "
                var year = collapsibleCalendar.selectedDay.year.toString()
                Toast.makeText(context,"$day : $month : $year",Toast.LENGTH_SHORT).show()


            }

            override fun onItemClick(v: View?) {
            }

        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmentmenu, container, false)
    }

    override fun onStart() {
        super.onStart()
        progressload.show()
        luckyViewModel.getItem()
        luckyViewModel.listItem.observe(this, Observer {
            progressload.hide()
        })

    }

    override fun onStop() {
        super.onStop()
        progressload.hide()

    }

    companion object{
        @JvmStatic
        fun newInstance(): Menu1Fragment{
            val bundle = Bundle()
            val fragment = Menu1Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}