package com.example.bubblepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bubblepicker.View.Menu1Fragment
import com.example.bubblepicker.View.Menu2Fragment
import com.example.bubblepicker.View.Menu3Fragment
import com.example.bubblepicker.View.Menu4Fragment
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var  bottomNavigationItem1 = BottomNavigationItem("Like",ContextCompat.getColor(this,R.color.green),R.drawable.menu1)
        var  bottomNavigationItem2 = BottomNavigationItem("Love",ContextCompat.getColor(this,R.color.green),R.drawable.menu2)
        var  bottomNavigationItem3 = BottomNavigationItem("Luck",ContextCompat.getColor(this,R.color.green),R.drawable.menu3)
        var  bottomNavigationItem4 = BottomNavigationItem("Lucky",ContextCompat.getColor(this,R.color.green),R.drawable.menu4)
        bottomNavigation.addTab(bottomNavigationItem1)
        bottomNavigation.addTab(bottomNavigationItem2)
        bottomNavigation.addTab(bottomNavigationItem3)
        bottomNavigation.addTab(bottomNavigationItem4)
        bottomNavigation.selectTab(0)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,Menu1Fragment.newInstance(),"menu1").commit()


        bottomNavigation.setOnBottomNavigationItemClickListener { index ->
            when(index){
                0 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,Menu1Fragment.newInstance(),"menu1").commit()
                }
                1 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Menu2Fragment.newInstance(),"menu2").commit()
                }
                2 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Menu3Fragment.newInstance(),"menu3").commit()
                }
                3 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, Menu4Fragment.newInstance(),"menu4").commit()
                }

            }
        }

    }

}
