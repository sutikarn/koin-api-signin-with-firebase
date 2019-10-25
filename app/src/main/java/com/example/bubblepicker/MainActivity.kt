package com.example.bubblepicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject
import com.easyfingerprint.EasyFingerPrint
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

    fun biometic(){
        EasyFingerPrint(this)
            .setTittle("Sign in")
            .setSubTittle("Login With Fingers Print")
            .setDescription("In order to use the Fingerprint sensor we need your authorization first.e")
            .setColorPrimary(R.color.colorPrimary)
            .setIcon(ContextCompat.getDrawable(this,R.mipmap.ic_launcher_round))
            .setListern(object : EasyFingerPrint.ResultFingerPrintListern{
                override fun onError(mensage: String, code: Int) {

                    when(code){
                        EasyFingerPrint.CODE_ERRO_CANCEL -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_GREATER_ANDROID_M -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_HARDWARE_NOT_SUPPORTED -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_NOT_ABLED -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_NOT_FINGERS -> { } // TO DO
                        EasyFingerPrint.CODE_NOT_PERMISSION_BIOMETRIC -> { } // TO DO
                    }

                    Toast.makeText(this@MainActivity,"Error: $mensage / $code",Toast.LENGTH_SHORT).show()
                }

                override fun onSucess(cryptoObject: CryptoObject?) {
                    Toast.makeText(this@MainActivity,"Sucess",Toast.LENGTH_SHORT).show()
                }

            })
            .startScan()
    }



}
