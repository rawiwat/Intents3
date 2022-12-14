package com.example.intents3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val STRING_DATA_KEY = "PASSED_DATA"
        const val INT_DATA_KEY = "PASSED_DATA_INT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simple_intent_button.setOnClickListener{
            val intent = Intent(this, FullscreenActivity::class.java)
            startActivity(intent)
        }
        data_intent_button.setOnClickListener{
            val intent = Intent(this, FullscreenActivity::class.java)
            intent.putExtra("PASSED_DATA","Hello")
            startActivity(intent)
        }
        challenge_intent_button.setOnClickListener{
            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra(INT_DATA_KEY, 5)
            startActivity(intent)
        }

    }
}

