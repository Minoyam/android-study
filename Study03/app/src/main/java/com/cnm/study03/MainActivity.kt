package com.cnm.study03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_send.setOnClickListener {
            val text = et_input.text.toString()
            intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra(NAME, text)
            startActivityForResult(intent, REQ_SECOND)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_SECOND -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        tv_helloWorld.text = data?.getStringExtra(NAME)
                    }
                    Activity.RESULT_CANCELED -> {
                        tv_helloWorld.text = "취소"
                    }
                }
            }
        }
    }

    companion object {
        const val REQ_SECOND = 1000
        const val NAME = "key"
    }
}

