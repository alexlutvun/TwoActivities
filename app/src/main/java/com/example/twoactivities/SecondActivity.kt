package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
private var mReply: EditText? = null

class SecondActivity : AppCompatActivity() {
    private val LOG_TAG = SecondActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text=message
        mReply = findViewById(R.id.editText_second)

    }

    fun returnReply(view: View) {
        val reply = mReply?.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK,replyIntent)
        Log.d(LOG_TAG, "End SecondActivity");
        finish()
    }
}