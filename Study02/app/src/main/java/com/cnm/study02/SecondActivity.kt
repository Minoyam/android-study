package com.cnm.study02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e("text", "onCreate SecondActivity")
        val text = intent.getStringExtra("key") ?: ""
        tv_helloWorld.text = text

        bt_send.setOnClickListener{
            val text = et_input.text.toString()

            val intent = Intent()
            intent.putExtra("key",text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("text", "onStart SecondActivity")


    }

    override fun onResume() {
        super.onResume()
        Log.e("text", "onResume SecondActivity")

    }

    override fun onPause() {
        Log.e("text", "onPause SecondActivity")
        super.onPause()

    }

    override fun onStop() {
        Log.e("text", "onStop SecondActivity")
        super.onStop()

    }

    override fun onDestroy() {
        Log.e("text", "onDestroy SecondActivity")
        super.onDestroy()

    }
}