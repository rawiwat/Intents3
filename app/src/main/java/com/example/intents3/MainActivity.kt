package com.example.intents3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val STRING_DATA_KEY = "PASSED_DATA"
        const val INT_DATA_KEY = "PASSED_DATA_INT"
        const val IMAGE_REQUEST_CODE = 5
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
        intent_for_result.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null){
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }
    }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val image = data?.data
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

