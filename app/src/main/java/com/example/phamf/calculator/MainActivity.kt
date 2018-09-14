package com.example.phamf.calculator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edt_input.showSoftInputOnFocus = false
        edt_input.requestFocus()
        addEvent()
    }



    fun addEvent () {

        var widget : View.OnClickListener = View.OnClickListener {
            view : View ->
            var excutePos = edt_input.selectionStart
            when (view.id) {
                R.id.btn0 -> edt_input.text.insert(excutePos, "0")

                R.id.btn1 -> edt_input.text.insert(excutePos, "1")

                R.id.btn2 -> edt_input.text.insert(excutePos, "2")

                R.id.btn3 -> edt_input.text.insert(excutePos, "3")

                R.id.btn4 -> edt_input.text.insert(excutePos, "4")

                R.id.btn5 -> edt_input.text.insert(excutePos, "5")

                R.id.btn6 -> edt_input.text.insert(excutePos, "6")

                R.id.btn7 -> edt_input.text.insert(excutePos, "7")

                R.id.btn8 -> edt_input.text.insert(excutePos, "8")

                R.id.btn9 -> edt_input.text.insert(excutePos, "9")

                R.id.btn_plus -> edt_input.text.insert(excutePos, "+")

                R.id.btn_subtract -> edt_input.text.insert(excutePos, "-")

                R.id.btn_multiply -> edt_input.text.insert(excutePos, "*")

                R.id.btn_divide -> edt_input.text.insert(excutePos, "/")

                R.id.btn_sqr -> edt_input.text.insert(excutePos, "^2")

                R.id.btn_open_parent -> edt_input.text.insert(excutePos, "(")

                R.id.btn_close_parent -> edt_input.text.insert(excutePos, ")")

                R.id.btn_delete ->
                {
                    if ((excutePos == 0) && (edt_input.textSize > 0)) {
                        edt_input.text.delete(0, 1)
                    } else if (excutePos == edt_input.text.length - 1) {
                        edt_input.text.delete(edt_input.text.length - 2, edt_input.text.length - 1)
                    } else {
                        edt_input.text.delete(excutePos - 1, excutePos)
                    }

                }

                R.id.btn_delete_all -> edt_input.text.delete(0, edt_input.length())

                R.id.btn_calc -> {
                    txt_result.text = if (txt_result.text.isNotEmpty()) process(edt_input.text.toString().removeAllSpace()
                                                                                                         .processMinus())
                                      else "0"
                }

            }
        }
        btn0.setOnClickListener(widget)
        btn1.setOnClickListener(widget)
        btn2.setOnClickListener(widget)
        btn3.setOnClickListener(widget)
        btn4.setOnClickListener(widget)
        btn5.setOnClickListener(widget)
        btn6.setOnClickListener(widget)
        btn7.setOnClickListener(widget)
        btn8.setOnClickListener(widget)
        btn9.setOnClickListener(widget)
        btn_plus.setOnClickListener(widget)
        btn_subtract.setOnClickListener(widget)
        btn_multiply.setOnClickListener(widget)
        btn_divide.setOnClickListener(widget)
        btn_sqr.setOnClickListener(widget)
        btn_open_parent.setOnClickListener(widget)
        btn_close_parent.setOnClickListener(widget)
        btn_delete.setOnClickListener(widget)
        btn_delete_all.setOnClickListener(widget)
        btn_calc.setOnClickListener(widget)
    }


}





