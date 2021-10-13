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
        val row0 = listOf<Int>(1,3,0,6,0,0,0,8,0)
        val row1 = listOf<Int>(0,4,6,0,3,0,0,0,0)
        val row2 = listOf<Int>(0,2,0,5,0,0,0,0,0)
        val row3 = listOf<Int>(0,0,0,2,0,0,1,0,6)
        val row4 = listOf<Int>(0,9,0,0,5,7,0,0,0)
        val row5 = listOf<Int>(8,0,0,0,0,0,0,4,5)
        val row6 = listOf<Int>(0,0,0,0,0,0,3,7,0)
        val row7 = listOf<Int>(0,0,0,0,6,3,4,0,0)
        val row8 = listOf<Int>(0,0,0,0,0,0,5,0,1)

        val puzzle = listOf<List<Int>>(row0, row1, row2, row3, row4, row5, row6, row7, row8)

        val board = Board(puzzle)
        println(board)

        lifecycleScope.launchWhenCreated {
            //tvResponse.text = board.toString()

            val response = try {
                RetrofitInstance.api.postBoard(board)
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