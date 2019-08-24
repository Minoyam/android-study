package com.cnm.study01

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.clichlistener_study1.*
import kotlinx.android.synthetic.main.clicklistener_study.*
import java.util.*

class MainActivity : AppCompatActivity() {

//    private lateinit var etInput: EditText
//    private lateinit var tvClick: TextView
//    private lateinit var tvOutput: TextView
//    private lateinit var tvClick1: TextView
//
//    private var num = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.clickListener_study)
//
//        etInput = et_input
//        tvClick = tv_click
//        tvOutput = tv_output
//        tvClick1 = tv_click1
//
//        tvClick.setOnClickListener {
//            val input = etInput.text.toString()
//            tvOutput.text = input
//        }
//        tvClick1.setOnClickListener {
//            (it as TextView).text = fruits[num]
//            num = (num + 1) % fruits.size
//        }
//
//    }
//
//    companion object {
//        private val fruits = arrayOf("사과", "바나나", "복숭아", "딸기", "포도")
//    }

    private lateinit var tvToast: TextView
    private lateinit var tvLog: TextView
    private lateinit var tvDialLog: TextView
    private lateinit var toast: Toast
    private var count = 0

    private val checked = booleanArrayOf(false, false, false, false, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clichlistener_study1)
        tvLog = tv_log
        tvDialLog = tv_dialLog
        tvToast = tv_toast

        tvLog.setOnClickListener {
            Log.e("tag", "message", Throwable("error message"))
            Log.d("tag", "message", Throwable("error message"))
            Log.i("tag", "message", Throwable("error message"))
            Log.w("tag", "message", Throwable("error message"))
            Log.v("tag", "message", Throwable("error message"))
        }
        tvDialLog.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("여기는 타이틀")
//                .setMessage("여기는 메세지")
//                .setItems(fruits) { _, which ->
//                    Toast.makeText(this,"선택한 과일은 ${fruits[which]}",Toast.LENGTH_SHORT).show()
//                }
                .setMultiChoiceItems(
                    fruits,
                    checked ,
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.e("TAG","${fruits[which]}가 $isChecked")
                            checked[which] = isChecked
                        }
                    })
                .setNegativeButton("Negative") { _, _ ->
                    Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Positvie") { _, _ ->
                    Toast.makeText(this, "Positvie", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral") { _, _ ->
                    Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
                }
                .show()

        }
        toast = Toast.makeText(this@MainActivity, "이건 토스트 메세지 $count", Toast.LENGTH_LONG)
        tvToast.setOnClickListener {
            count++
            toast.setText("수정된 토스트 메세지 $count")
            toast.duration = Toast.LENGTH_SHORT
            toast.show()

        }
    }



    companion object {
        private val fruits = arrayOf("사과", "바나나", "복숭아", "딸기", "포도")
    }
}
