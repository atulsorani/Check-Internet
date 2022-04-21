package com.atul.checkinternet

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->

            if (isConnected) {
                Snackbar.make(findViewById(android.R.id.content), "Internet Connected", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(findViewById(android.R.id.content), "Internet Not Connected", Snackbar.LENGTH_LONG).show();
            }
        })
    }
}