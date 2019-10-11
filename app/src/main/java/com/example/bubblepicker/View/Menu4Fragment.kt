package com.example.bubblepicker.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bubblepicker.Model.ListLucky
import com.example.bubblepicker.R
import com.example.bubblepicker.ViewModel.LuckyViewModel
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.model.PickerItem
import kotlinx.android.synthetic.main.bubblepickerfragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class Menu4Fragment: Fragment() {

    private val luckyViewModel:LuckyViewModel by viewModel()

    override fun onStart() {
        super.onStart()

        luckyViewModel.getItem()
        luckyViewModel.listItem.observe(this, Observer(function = fun(it: ListLucky?) {
            it?.let {

            }
        }))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val titles = resources.getStringArray(R.array.countries)
        val colors = resources.obtainTypedArray(R.array.colors)
        val images = resources.obtainTypedArray(R.array.images)

        picker.adapter = object : BubblePickerAdapter {

            override val totalCount = titles.size

            override fun getItem(position: Int): PickerItem {
                return PickerItem().apply {
                    title = titles[position]
                    gradient = BubbleGradient(colors.getColor((position * 2) % 8, 0),
                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL)
                    textColor = ContextCompat.getColor(context!!, android.R.color.white)
                    backgroundImage = ContextCompat.getDrawable(context!!, images.getResourceId(position, 0))
                }
            }
        }
        colors.recycle()
        images.recycle()
        picker.bubbleSize = 5
        picker.listener = object : BubblePickerListener {

            override fun onBubbleSelected(item: PickerItem) {
                progressload.show()
                fragmentManager!!.beginTransaction().replace(R.id.fragmentContainer,ResultFragment.newInstance(item.title!!)).addToBackStack("menu4").commit()

            }

            override fun onBubbleDeselected(item: PickerItem) {

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bubblepickerfragment, container, false)
    }
    override fun onResume() {
        super.onResume()
        picker.visibility = VISIBLE
        picker.onResume()
    }

    override fun onPause() {
        super.onPause()
        picker.onPause()
    }

    companion object{
        @JvmStatic
        fun newInstance(): Menu4Fragment {
            val bundle = Bundle()
            val fragment = Menu4Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}