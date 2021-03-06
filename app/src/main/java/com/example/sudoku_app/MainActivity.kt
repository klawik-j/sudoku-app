package com.example.sudoku_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var btnGoToSolveActivity: Button
    private lateinit var btnGoToOCRView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToSolveActivity = findViewById(R.id.btnGoToSolveActivity)
        btnGoToOCRView = findViewById(R.id.btnGoToOCRView)


        btnGoToSolveActivity.setOnClickListener {
            Intent(this, SolveActivity::class.java).also {
                startActivity(it)
            }
        }

        btnGoToOCRView.setOnClickListener {
            Intent(this, OcrActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}