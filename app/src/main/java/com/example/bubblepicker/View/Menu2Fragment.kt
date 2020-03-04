package com.example.bubblepicker.View

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bachors.wordtospan.WordToSpan
import com.example.bubblepicker.R
import kotlinx.android.synthetic.main.fragment2.*


class Menu2Fragment :Fragment() {

    @SuppressLint("PrivateResource")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val link = WordToSpan()
        var tv = "<p><strong>คลัง ยัน ภาษีที่ดินใหม่ ไม่เป็นภาระเพิ่มให้ประชาชน ระบุสำรวจแล้วพบบ้าน-คอนโดราคาเกิน 50 ล้านบาท มีแค่ 10,000 หลังต้องเสียภาษี ขณะที่ที่ดินเพื่อการเกษตรไม่เกิน 50 ล้านบาทก็ปลอดภาษีด้วย คาดเก็บภาษีเข้าแผ่นดินได้เพิ่มปีละ 10,000 ล้านบาท</strong></p><p>นายลวรณ แสงสนิท ผู้อำนวยการสำนักงานเศรษฐกิจการคลัง (สศค.) และโฆษกกระทรวงการคลัง ยืนยัน การบังคับใช้พ.ร.บ.ภาษีที่ดินและสิ่งปลูกสร้าง พ.ศ.2562 ในวันที่ 1 ม.ค.2563 นั้น จะไม่เป็นภาระค่าใช้จ่ายที่เพิ่มขึ้นให้กับประชาชน เพราะจากการสำรวจพบว่า ประชาชนส่วนใหญ่ของประเทศถึง 99.6% มีบ้านและคอนโดมีเนียมเพื่ออยู่หลักมีราคาประเมินไม่เกิน 50 ล้านบาท ซึ่งจะไม่เสียภาษีดังกล่าวอยู่แล้ว ส่วนคนที่มีบ้านหลังที่สอง หรือหลังถัดๆ ไป แต่อยู่อาศัยเองจริง ก็จะเสียภาษีแต่เสียในอัตราต่ำ เช่น บ้านราคา 1 ล้านบาท เสียภาษีเริ่มต้นแค่ 200 บาทต่อปีเท่านั้น ขณะที่บ้านและคอนโด ราคาเกิน 50 ล้านบาท เข้าข่ายต้องเสียภาษีมีประมาณแค่ 1 หมื่นหลังเท่านั้น</p> https://www.thansettakij.com/content/money_market/417071?utm_source=homepage_hilight&utm_medium=internal_referral"
        link.setColorTAG(Color.GREEN)
            .setColorURL(Color.MAGENTA)
            .setColorPHONE(Color.RED)
            .setColorMAIL(resources.getColor(R.color.colorPrimary))
            .setColorMENTION(resources.getColor(R.color.colorAccent))
            .setUnderlineURL(true)
            .setLink(tv)
            .into(textView2)
            .setClickListener { type, text ->
                // type: "tag", "mail", "url", "phone", "mention" or "custom"
                Toast.makeText(
                    context,
                    "Type: $type\nText: $text",
                    Toast.LENGTH_LONG
                ).show()
            }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)

    }

    companion object{
        @JvmStatic
        fun newInstance(): Menu2Fragment {
            val bundle = Bundle()
            val fragment = Menu2Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}