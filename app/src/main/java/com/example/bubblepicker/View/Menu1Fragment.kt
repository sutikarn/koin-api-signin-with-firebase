package com.example.bubblepicker.View

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bubblepicker.OnSwipeTouchListener
import com.example.bubblepicker.R
import com.example.bubblepicker.ViewModel.LuckyViewModel
import com.shrikanthravi.collapsiblecalendarview.data.Day
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import kotlinx.android.synthetic.main.fragmentmenu.*
import org.koin.android.viewmodel.ext.android.viewModel

class Menu1Fragment :Fragment() {


    private val luckyViewModel: LuckyViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backgroundmenu.setBackgroundColor(ContextCompat.getColor(context!!,R.color.menu1))
        bgbg.setOnTouchListener(object :OnSwipeTouchListener(context){

            override fun onSwipeRight() {

                collapsibleCalendar.prevMonth()
            }

            override fun onSwipeLeft() {

                collapsibleCalendar.nextMonth()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                collapsibleCalendar.expand(400)
            }

            override fun onSwipeTop() {
                super.onSwipeTop()
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
}