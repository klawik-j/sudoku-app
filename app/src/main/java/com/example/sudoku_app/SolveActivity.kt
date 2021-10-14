package com.example.sudoku_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class SolveActivity : AppCompatActivity() {

    private lateinit var btnSolve: Button

    private lateinit var et_cell_A1: EditText
    private lateinit var et_cell_A2: EditText
    private lateinit var et_cell_A3: EditText
    private lateinit var et_cell_A4: EditText
    private lateinit var et_cell_A5: EditText
    private lateinit var et_cell_A6: EditText
    private lateinit var et_cell_A7: EditText
    private lateinit var et_cell_A8: EditText
    private lateinit var et_cell_A9: EditText

    private lateinit var et_cell_B1: EditText
    private lateinit var et_cell_B2: EditText
    private lateinit var et_cell_B3: EditText
    private lateinit var et_cell_B4: EditText
    private lateinit var et_cell_B5: EditText
    private lateinit var et_cell_B6: EditText
    private lateinit var et_cell_B7: EditText
    private lateinit var et_cell_B8: EditText
    private lateinit var et_cell_B9: EditText

    private lateinit var et_cell_C1: EditText
    private lateinit var et_cell_C2: EditText
    private lateinit var et_cell_C3: EditText
    private lateinit var et_cell_C4: EditText
    private lateinit var et_cell_C5: EditText
    private lateinit var et_cell_C6: EditText
    private lateinit var et_cell_C7: EditText
    private lateinit var et_cell_C8: EditText
    private lateinit var et_cell_C9: EditText

    private lateinit var et_cell_D1: EditText
    private lateinit var et_cell_D2: EditText
    private lateinit var et_cell_D3: EditText
    private lateinit var et_cell_D4: EditText
    private lateinit var et_cell_D5: EditText
    private lateinit var et_cell_D6: EditText
    private lateinit var et_cell_D7: EditText
    private lateinit var et_cell_D8: EditText
    private lateinit var et_cell_D9: EditText

    private lateinit var et_cell_E1: EditText
    private lateinit var et_cell_E2: EditText
    private lateinit var et_cell_E3: EditText
    private lateinit var et_cell_E4: EditText
    private lateinit var et_cell_E5: EditText
    private lateinit var et_cell_E6: EditText
    private lateinit var et_cell_E7: EditText
    private lateinit var et_cell_E8: EditText
    private lateinit var et_cell_E9: EditText

    private lateinit var et_cell_F1: EditText
    private lateinit var et_cell_F2: EditText
    private lateinit var et_cell_F3: EditText
    private lateinit var et_cell_F4: EditText
    private lateinit var et_cell_F5: EditText
    private lateinit var et_cell_F6: EditText
    private lateinit var et_cell_F7: EditText
    private lateinit var et_cell_F8: EditText
    private lateinit var et_cell_F9: EditText

    private lateinit var et_cell_G1: EditText
    private lateinit var et_cell_G2: EditText
    private lateinit var et_cell_G3: EditText
    private lateinit var et_cell_G4: EditText
    private lateinit var et_cell_G5: EditText
    private lateinit var et_cell_G6: EditText
    private lateinit var et_cell_G7: EditText
    private lateinit var et_cell_G8: EditText
    private lateinit var et_cell_G9: EditText

    private lateinit var et_cell_H1: EditText
    private lateinit var et_cell_H2: EditText
    private lateinit var et_cell_H3: EditText
    private lateinit var et_cell_H4: EditText
    private lateinit var et_cell_H5: EditText
    private lateinit var et_cell_H6: EditText
    private lateinit var et_cell_H7: EditText
    private lateinit var et_cell_H8: EditText
    private lateinit var et_cell_H9: EditText

    private lateinit var et_cell_I1: EditText
    private lateinit var et_cell_I2: EditText
    private lateinit var et_cell_I3: EditText
    private lateinit var et_cell_I4: EditText
    private lateinit var et_cell_I5: EditText
    private lateinit var et_cell_I6: EditText
    private lateinit var et_cell_I7: EditText
    private lateinit var et_cell_I8: EditText
    private lateinit var et_cell_I9: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solve)


        btnSolve = findViewById(R.id.btnSolve)

        et_cell_A1 = findViewById(R.id.et_cell_A1)
        et_cell_A2 = findViewById(R.id.et_cell_A2)
        et_cell_A3 = findViewById(R.id.et_cell_A3)
        et_cell_A4 = findViewById(R.id.et_cell_A4)
        et_cell_A5 = findViewById(R.id.et_cell_A5)
        et_cell_A6 = findViewById(R.id.et_cell_A6)
        et_cell_A7 = findViewById(R.id.et_cell_A7)
        et_cell_A8 = findViewById(R.id.et_cell_A8)
        et_cell_A9 = findViewById(R.id.et_cell_A9)

        et_cell_B1 = findViewById(R.id.et_cell_B1)
        et_cell_B2 = findViewById(R.id.et_cell_B2)
        et_cell_B3 = findViewById(R.id.et_cell_B3)
        et_cell_B4 = findViewById(R.id.et_cell_B4)
        et_cell_B5 = findViewById(R.id.et_cell_B5)
        et_cell_B6 = findViewById(R.id.et_cell_B6)
        et_cell_B7 = findViewById(R.id.et_cell_B7)
        et_cell_B8 = findViewById(R.id.et_cell_B8)
        et_cell_B9 = findViewById(R.id.et_cell_B9)

        et_cell_C1 = findViewById(R.id.et_cell_C1)
        et_cell_C2 = findViewById(R.id.et_cell_C2)
        et_cell_C3 = findViewById(R.id.et_cell_C3)
        et_cell_C4 = findViewById(R.id.et_cell_C4)
        et_cell_C5 = findViewById(R.id.et_cell_C5)
        et_cell_C6 = findViewById(R.id.et_cell_C6)
        et_cell_C7 = findViewById(R.id.et_cell_C7)
        et_cell_C8 = findViewById(R.id.et_cell_C8)
        et_cell_C9 = findViewById(R.id.et_cell_C9)

        et_cell_D1 = findViewById(R.id.et_cell_D1)
        et_cell_D2 = findViewById(R.id.et_cell_D2)
        et_cell_D3 = findViewById(R.id.et_cell_D3)
        et_cell_D4 = findViewById(R.id.et_cell_D4)
        et_cell_D5 = findViewById(R.id.et_cell_D5)
        et_cell_D6 = findViewById(R.id.et_cell_D6)
        et_cell_D7 = findViewById(R.id.et_cell_D7)
        et_cell_D8 = findViewById(R.id.et_cell_D8)
        et_cell_D9 = findViewById(R.id.et_cell_D9)

        et_cell_E1 = findViewById(R.id.et_cell_E1)
        et_cell_E2 = findViewById(R.id.et_cell_E2)
        et_cell_E3 = findViewById(R.id.et_cell_E3)
        et_cell_E4 = findViewById(R.id.et_cell_E4)
        et_cell_E5 = findViewById(R.id.et_cell_E5)
        et_cell_E6 = findViewById(R.id.et_cell_E6)
        et_cell_E7 = findViewById(R.id.et_cell_E7)
        et_cell_E8 = findViewById(R.id.et_cell_E8)
        et_cell_E9 = findViewById(R.id.et_cell_E9)

        et_cell_F1 = findViewById(R.id.et_cell_F1)
        et_cell_F2 = findViewById(R.id.et_cell_F2)
        et_cell_F3 = findViewById(R.id.et_cell_F3)
        et_cell_F4 = findViewById(R.id.et_cell_F4)
        et_cell_F5 = findViewById(R.id.et_cell_F5)
        et_cell_F6 = findViewById(R.id.et_cell_F6)
        et_cell_F7 = findViewById(R.id.et_cell_F7)
        et_cell_F8 = findViewById(R.id.et_cell_F8)
        et_cell_F9 = findViewById(R.id.et_cell_F9)

        et_cell_G1 = findViewById(R.id.et_cell_G1)
        et_cell_G2 = findViewById(R.id.et_cell_G2)
        et_cell_G3 = findViewById(R.id.et_cell_G3)
        et_cell_G4 = findViewById(R.id.et_cell_G4)
        et_cell_G5 = findViewById(R.id.et_cell_G5)
        et_cell_G6 = findViewById(R.id.et_cell_G6)
        et_cell_G7 = findViewById(R.id.et_cell_G7)
        et_cell_G8 = findViewById(R.id.et_cell_G8)
        et_cell_G9 = findViewById(R.id.et_cell_G9)

        et_cell_H1 = findViewById(R.id.et_cell_H1)
        et_cell_H2 = findViewById(R.id.et_cell_H2)
        et_cell_H3 = findViewById(R.id.et_cell_H3)
        et_cell_H4 = findViewById(R.id.et_cell_H4)
        et_cell_H5 = findViewById(R.id.et_cell_H5)
        et_cell_H6 = findViewById(R.id.et_cell_H6)
        et_cell_H7 = findViewById(R.id.et_cell_H7)
        et_cell_H8 = findViewById(R.id.et_cell_H8)
        et_cell_H9 = findViewById(R.id.et_cell_H9)

        et_cell_I1 = findViewById(R.id.et_cell_I1)
        et_cell_I2 = findViewById(R.id.et_cell_I2)
        et_cell_I3 = findViewById(R.id.et_cell_I3)
        et_cell_I4 = findViewById(R.id.et_cell_I4)
        et_cell_I5 = findViewById(R.id.et_cell_I5)
        et_cell_I6 = findViewById(R.id.et_cell_I6)
        et_cell_I7 = findViewById(R.id.et_cell_I7)
        et_cell_I8 = findViewById(R.id.et_cell_I8)
        et_cell_I9 = findViewById(R.id.et_cell_I9)

        /*val row0 = listOf<Int>(1,3,0,6,0,0,0,8,0)
        val row1 = listOf<Int>(0,4,6,0,3,0,0,0,0)
        val row2 = listOf<Int>(0,2,0,5,0,0,0,0,0)
        val row3 = listOf<Int>(0,0,0,2,0,0,1,0,6)
        val row4 = listOf<Int>(0,9,0,0,5,7,0,0,0)
        val row5 = listOf<Int>(8,0,0,0,0,0,0,4,5)
        val row6 = listOf<Int>(0,0,0,0,0,0,3,7,0)
        val row7 = listOf<Int>(0,0,0,0,6,3,4,0,0)
        val row8 = listOf<Int>(0,0,0,0,0,0,5,0,1)*/

        /*al row0 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row1 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row2 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row3 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row4 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row5 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row6 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row7 = listOf<Int>(0,0,0,0,0,0,0,0,0)
        val row8 = listOf<Int>(0,0,0,0,0,0,0,0,0)*/

        //val puzzle = listOf<List<Int>>(row0, row1, row2, row3, row4, row5, row6, row7, row8)

        //val board = Board(puzzle)
        //println(board)

        btnSolve.setOnClickListener {
            /*val puzzle = listOf<List<Int>>(
                listOf<Int>(
                    et_cell_A1.text.toString().toInt(),
                    et_cell_A2.text.toString().toInt(),
                    et_cell_A3.text.toString().toInt(),
                    et_cell_A4.text.toString().toInt(),
                    et_cell_A5.text.toString().toInt(),
                    et_cell_A6.text.toString().toInt(),
                    et_cell_A7.text.toString().toInt(),
                    et_cell_A8.text.toString().toInt(),
                    et_cell_A9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_B1.text.toString().toInt(),
                    et_cell_B2.text.toString().toInt(),
                    et_cell_B3.text.toString().toInt(),
                    et_cell_B4.text.toString().toInt(),
                    et_cell_B5.text.toString().toInt(),
                    et_cell_B6.text.toString().toInt(),
                    et_cell_B7.text.toString().toInt(),
                    et_cell_B8.text.toString().toInt(),
                    et_cell_B9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_C1.text.toString().toInt(),
                    et_cell_C2.text.toString().toInt(),
                    et_cell_C3.text.toString().toInt(),
                    et_cell_C4.text.toString().toInt(),
                    et_cell_C5.text.toString().toInt(),
                    et_cell_C6.text.toString().toInt(),
                    et_cell_C7.text.toString().toInt(),
                    et_cell_C8.text.toString().toInt(),
                    et_cell_C9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_D1.text.toString().toInt(),
                    et_cell_D2.text.toString().toInt(),
                    et_cell_D3.text.toString().toInt(),
                    et_cell_D4.text.toString().toInt(),
                    et_cell_D5.text.toString().toInt(),
                    et_cell_D6.text.toString().toInt(),
                    et_cell_D7.text.toString().toInt(),
                    et_cell_D8.text.toString().toInt(),
                    et_cell_D9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_E1.text.toString().toInt(),
                    et_cell_E2.text.toString().toInt(),
                    et_cell_E3.text.toString().toInt(),
                    et_cell_E4.text.toString().toInt(),
                    et_cell_E5.text.toString().toInt(),
                    et_cell_E6.text.toString().toInt(),
                    et_cell_E7.text.toString().toInt(),
                    et_cell_E8.text.toString().toInt(),
                    et_cell_E9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_F1.text.toString().toInt(),
                    et_cell_F2.text.toString().toInt(),
                    et_cell_F3.text.toString().toInt(),
                    et_cell_F4.text.toString().toInt(),
                    et_cell_F5.text.toString().toInt(),
                    et_cell_F6.text.toString().toInt(),
                    et_cell_F7.text.toString().toInt(),
                    et_cell_F8.text.toString().toInt(),
                    et_cell_F9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_G1.text.toString().toInt(),
                    et_cell_G2.text.toString().toInt(),
                    et_cell_G3.text.toString().toInt(),
                    et_cell_G4.text.toString().toInt(),
                    et_cell_G5.text.toString().toInt(),
                    et_cell_G6.text.toString().toInt(),
                    et_cell_G7.text.toString().toInt(),
                    et_cell_G8.text.toString().toInt(),
                    et_cell_G9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_H1.text.toString().toInt(),
                    et_cell_H2.text.toString().toInt(),
                    et_cell_H3.text.toString().toInt(),
                    et_cell_H4.text.toString().toInt(),
                    et_cell_H5.text.toString().toInt(),
                    et_cell_H6.text.toString().toInt(),
                    et_cell_H7.text.toString().toInt(),
                    et_cell_H8.text.toString().toInt(),
                    et_cell_H9.text.toString().toInt()
                ),
                listOf<Int>(
                    et_cell_I1.text.toString().toInt(),
                    et_cell_I2.text.toString().toInt(),
                    et_cell_I3.text.toString().toInt(),
                    et_cell_I4.text.toString().toInt(),
                    et_cell_I5.text.toString().toInt(),
                    et_cell_I6.text.toString().toInt(),
                    et_cell_I7.text.toString().toInt(),
                    et_cell_I8.text.toString().toInt(),
                    et_cell_I9.text.toString().toInt()
                )
            )*/
            //print(puzzle)
            //val board = Board(puzzle)
            //print(board)
            /*val a = listOf<List<Int>>(
                    listOf<Int>(
                        et_cell_I1.text.toString().toInt(),
                        et_cell_I2.text.toString().toInt(),
                        et_cell_I3.text.toString().toInt(),
                        et_cell_I4.text.toString().toInt(),
                        et_cell_I5.text.toString().toInt(),
                        et_cell_I6.text.toString().toInt(),
                        et_cell_I7.text.toString().toInt(),
                        et_cell_I8.text.toString().toInt(),
                        et_cell_I9.text.toString().toInt()
                    ),
                    listOf<Int>(
                        et_cell_I1.text.toString().toInt(),
                        et_cell_I2.text.toString().toInt(),
                        et_cell_I3.text.toString().toInt(),
                        et_cell_I4.text.toString().toInt(),
                        et_cell_I5.text.toString().toInt(),
                        et_cell_I6.text.toString().toInt(),
                        et_cell_I7.text.toString().toInt(),
                        et_cell_I8.text.toString().toInt(),
                        et_cell_I9.text.toString().toInt()
                    ),
                )*/
            println(et_cell_I9.text.isBlank())

            /*GlobalScope.launch(Dispatchers.IO) {
                val response = try {
                    RetrofitInstance.api.postBoard(board)
                } catch (e: IOException) {
                    Log.e("[POST][SOLVE]", "IOException: ${e.message}")
                    return@launch
                } catch (e: HttpException) {
                    Log.e("[POST][SOLVE]", "HttpException: ${e.message}")
                    return@launch
                } catch (e: Exception) {
                    Log.e("[POST][SOLVE]", "Exception: ${e.message}")
                    return@launch
                }

                Log.e("[POST][SOLVE][response]", "response: $response \nresponse body: ${response.body()}")
                println(response)
                println(response.body())
            }*/
        }
    }
}