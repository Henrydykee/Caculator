package com.example.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View){

        if (isNewop){
            etShowNumber.setText("")
        }
            isNewop=false

        val EntryData=etShowNumber.text
        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDot.id->{
                buClickValue+="."
            }
            buPlusMinus.id->{
                buClickValue="-"+ buClickValue
            }
        }
        etShowNumber.setText(buClickValue)

    }
 var op="*"
    var OldNumber=""
    var isNewop=true
    fun buOpEvent(view:View){

        val buSelect  = view  as Button
        when (buSelect.id){
            buPlus.id->{

                op="+"
            }
            buMultiplication.id->{

                op="*"
            }
            buDivision.id->{

                op="/"
            }
            buMinus.id->{

                op="-"
            }
        }
        OldNumber=etShowNumber.text.toString()
        isNewop=true
    }


    fun buEqual(view:View){
       val newNumber=etShowNumber.text.toString()
        var FinalNumber:Double?=null
        when (op){
            "+"->{
                FinalNumber=OldNumber.toDouble()+newNumber.toDouble()

            }
            "-"->{
                FinalNumber=OldNumber.toDouble()-newNumber.toDouble()

            }
            "/"->{
                FinalNumber=OldNumber.toDouble()/newNumber.toDouble()

            }
            "*"->{
                FinalNumber=OldNumber.toDouble()*newNumber.toDouble()

            }
        }
        etShowNumber.setText((FinalNumber.toString()))
        isNewop=true

    }


    fun buPercent(view:View){
         val number=etShowNumber.text.toString().toDouble()
        etShowNumber.setText(number.toString())
    }

    fun buAC(view:View){
        etShowNumber.setText("")
        isNewop=true
    }
}
