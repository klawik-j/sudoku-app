package com.example.sudoku_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var tvResponse: TextView
    private lateinit var btnPost: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResponse = findViewById(R.id.tvResponse)
        btnPost = findViewById(R.id.btnPost)
        val row0 = listOf<Int>(1,2,3)
        val row1 = listOf<Int>(6,2,3)
        val row2 = listOf<Int>(7,2,3)
        val puzzle = listOf<List<Int>>(row0, row1, row2)

        val board = Board(puzzle)

        lifecycleScope.launchWhenCreated {
            //tvResponse.text = board.toString()

            val response = try {
                RetrofitInstance.api.getAccounts()
            } catch(e: IOException){
                Log.e("[POST][SOLVE]", "IOException: ${e.message}")
                return@launchWhenCreated
            } catch(e: HttpException){
                Log.e("[POST][SOLVE]", "HttpException: ${e.message}")
                return@launchWhenCreated
            } catch(e: Exception){
                Log.e("[POST][SOLVE]", "Exception: ${e.message}")
                return@launchWhenCreated
            }

            println(response)
            println(response.body())

        }
    }

    private fun postSolveRequest(board: Board) {
        //RetrofitInstance
    }
}