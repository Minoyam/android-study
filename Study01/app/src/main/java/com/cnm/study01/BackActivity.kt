package com.cnm.study01

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private val time = mutableListOf<Long>()

class BackActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clichlistener_study1)
    }

    override fun onBackPressed() {
        time.add(System.currentTimeMillis())
        Toast.makeText(this, "뒤로가기를 한번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG).show()

        if (time.size >= 2) {
            if (time[1] - time[0] <= 2000) {
                super.onBackPressed()
            }
            time.clear()
        }

    }

//    private var backPressTime = 0L
//
//    override fun onBackPressed() {
//        val time = System.currentTimeMillis()
//        if (time - backPressTime > 2000L) {
//            Toast.makeText(this, "뒤로가기를 한번더 누르시면 앱이 종료 됩니다.", Toast.LENGTH_LONG).show()
//            backPressTime = time
//        } else {
//            super.onBackPressed()
//        }
//    }
}
