package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var one : Button
    lateinit var two : Button
    lateinit var three : Button
    lateinit var four : Button
    lateinit var five : Button
    lateinit var six : Button
    lateinit var seven : Button
    lateinit var eight : Button
    lateinit var nine : Button
    lateinit var zero : Button

    lateinit var plus : Button
    lateinit var minus : Button
    lateinit var multiply : Button
    lateinit var divide : Button
    lateinit var modulo : Button
    lateinit var power : Button

    lateinit var decimal : Button
    lateinit var ac : Button

    lateinit var equals : Button
    lateinit var back : ImageView

    lateinit var expression : TextView
    lateinit var result : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one = findViewById(R.id.Button13)
        two = findViewById(R.id.Button14)
        three = findViewById(R.id.Button15)
        four = findViewById(R.id.Button9)
        five = findViewById(R.id.Button10)
        six = findViewById(R.id.Button11)
        seven = findViewById(R.id.Button5)
        eight = findViewById(R.id.Button6)
        nine = findViewById(R.id.Button7)
        zero = findViewById(R.id.Button18)

        plus = findViewById(R.id.Button16)
        minus = findViewById(R.id.Button12)
        multiply = findViewById(R.id.Button8)
        divide = findViewById(R.id.Button4)
        modulo = findViewById(R.id.Button3)
        power = findViewById(R.id.Button17)

        decimal = findViewById(R.id.Button19)
        ac = findViewById(R.id.Button1)

        equals = findViewById(R.id.Button20)
        back = findViewById(R.id.Button2)

        expression = findViewById(R.id.Expression)
        result = findViewById(R.id.result)


        one.setOnClickListener{
            appendText("1",true)
        }

        two.setOnClickListener{
            appendText("2",true)
        }

        three.setOnClickListener{
            appendText("3",true)
        }

        four.setOnClickListener{
            appendText("4",true)
        }

        five.setOnClickListener{
            appendText("5",true)

        }

        six.setOnClickListener{
            appendText("6",true)

        }

        seven.setOnClickListener{
            appendText("7",true)

        }

        eight.setOnClickListener{
            appendText("8",true)

        }

        nine.setOnClickListener{
            appendText("9",true)

        }

        zero.setOnClickListener{
            appendText("0",true)

        }

        decimal.setOnClickListener{
            appendText(".",true)
        }

        ac.setOnClickListener{
            expression.text = ""
            result.text = ""

        }

        plus.setOnClickListener{
            appendText("+",false)

        }

        minus.setOnClickListener{
            appendText("-",false)

        }

        multiply.setOnClickListener{
            appendText("*",false)

        }

        divide.setOnClickListener{
            appendText("/",false)

        }

        modulo.setOnClickListener{
            appendText("%",false)

        }

        power.setOnClickListener{
            appendText("^",false)

        }

        back.setOnClickListener{
            if(expression.text.length == 1)
            {
                expression.text = ""
            }
            else if(expression.text.toString() != "")
            {
                expression.text = expression.text.subSequence(0,expression.text.length - 1)
            }
        }

        equals.setOnClickListener{
            try{
                val expr = ExpressionBuilder(expression.text.toString()).build()
                val ans = expr.evaluate()
                result.text = ans.toString()
            }
            catch (e : Exception)
            {
                result.text = e.message
            }
        }
    }

    private fun appendText(value : String, cleared : Boolean  )
    {
        if(result.text != "")
        {
            expression.text = ""
        }

        if(cleared)
        {
            result.text = ""
            expression.append(value)
        }
        else
        {
            expression.append(result.text)
            expression.append(value)
            result.text = ""
        }
    }

}