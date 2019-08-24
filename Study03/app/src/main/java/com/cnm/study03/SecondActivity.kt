package com.cnm.study03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv_helloWorld.text = intent.getStringExtra(MainActivity.NAME)
        bt_send.setOnClickListener {
            val text = et_input.text.toString()
            val intent = Intent()
            intent.putExtra(MainActivity.NAME, text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}