package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.practical2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName2: MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName2
        //setContentView(R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText: EditText = findViewById(R.id.nickname_edit)
 //       val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        //nicknameTextView.text = editText.text
        // editText.visibility = View.GONE
        binding.apply{
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
    }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)

    }

    private fun updateNickname(view: View){
  //      val editText = findViewById<EditText>(R.id.nickname_edit)
  //      val doneButton = findViewById<Button>(R.id.done_button)

        binding.apply{
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.VISIBLE
        }
   //     editText.visibility = View.VISIBLE
       // doneButton.visibility = View.VISIBLE
   //     view.visibility = View.GONE


    }
}