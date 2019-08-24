package com.cnm.study02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        tvHello = tv_helloWorld
//        tvHello.setOnClickListener {
//            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            startActivity(intent)
//        }
        bt_send.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val text = et_input.text.toString()
            intent.putExtra("key", text)
//            startActivity(intent)
            startActivityForResult(intent, 1002)
        }
        Log.e("text", "onCreate MainActivity")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1002 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        tv_helloWorld.text = data?.getStringExtra("key")
                    }
                    Activity.RESULT_CANCELED -> {
                        tv_helloWorld.text = "취소"
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("text", "onStart MainActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.e("text", "onResume MainActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.e("text", "onPause MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.e("text", "onStop MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("text", "onDestroy MainActivity")
    }
}
