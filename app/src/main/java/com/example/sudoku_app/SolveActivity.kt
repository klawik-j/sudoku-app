package com.example.sudoku_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class SolveActivity : AppCompatActivity() {

    private lateinit var btnSolve: Button
    private lateinit var btnClear: Button
    private lateinit var pbSolve: ProgressBar

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
        btnClear = findViewById(R.id.btnClear)
        pbSolve = findViewById(R.id.pbSolve)

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

        val boardFound: Boolean = intent.getBooleanExtra("EXTRA_boardFound", false)
        if(boardFound) {
            val boardFromOCR = intent.getSerializableExtra("EXTRA_board") as Board
            Log.e("[SOLVE][import]", "${boardFromOCR.puzzle}")
            et_cell_A1.setText(if(boardFromOCR.puzzle[0][0] == 0) "" else boardFromOCR.puzzle[0][0].toString())
            et_cell_A2.setText(if(boardFromOCR.puzzle[0][1] == 0) "" else boardFromOCR.puzzle[0][1].toString())
            et_cell_A3.setText(if(boardFromOCR.puzzle[0][2] == 0) "" else boardFromOCR.puzzle[0][2].toString())
            et_cell_A4.setText(if(boardFromOCR.puzzle[0][3] == 0) "" else boardFromOCR.puzzle[0][3].toString())
            et_cell_A5.setText(if(boardFromOCR.puzzle[0][4] == 0) "" else boardFromOCR.puzzle[0][4].toString())
            et_cell_A6.setText(if(boardFromOCR.puzzle[0][5] == 0) "" else boardFromOCR.puzzle[0][5].toString())
            et_cell_A7.setText(if(boardFromOCR.puzzle[0][6] == 0) "" else boardFromOCR.puzzle[0][6].toString())
            et_cell_A8.setText(if(boardFromOCR.puzzle[0][7] == 0) "" else boardFromOCR.puzzle[0][7].toString())
            et_cell_A9.setText(if(boardFromOCR.puzzle[0][8] == 0) "" else boardFromOCR.puzzle[0][8].toString())

            et_cell_B1.setText(if(boardFromOCR.puzzle[1][0] == 0) "" else boardFromOCR.puzzle[1][0].toString())
            et_cell_B2.setText(if(boardFromOCR.puzzle[1][1] == 0) "" else boardFromOCR.puzzle[1][1].toString())
            et_cell_B3.setText(if(boardFromOCR.puzzle[1][2] == 0) "" else boardFromOCR.puzzle[1][2].toString())
            et_cell_B4.setText(if(boardFromOCR.puzzle[1][3] == 0) "" else boardFromOCR.puzzle[1][3].toString())
            et_cell_B5.setText(if(boardFromOCR.puzzle[1][4] == 0) "" else boardFromOCR.puzzle[1][4].toString())
            et_cell_B6.setText(if(boardFromOCR.puzzle[1][5] == 0) "" else boardFromOCR.puzzle[1][5].toString())
            et_cell_B7.setText(if(boardFromOCR.puzzle[1][6] == 0) "" else boardFromOCR.puzzle[1][6].toString())
            et_cell_B8.setText(if(boardFromOCR.puzzle[1][7] == 0) "" else boardFromOCR.puzzle[1][7].toString())
            et_cell_B9.setText(if(boardFromOCR.puzzle[1][8] == 0) "" else boardFromOCR.puzzle[1][8].toString())

            et_cell_C1.setText(if(boardFromOCR.puzzle[2][0] == 0) "" else boardFromOCR.puzzle[2][0].toString())
            et_cell_C2.setText(if(boardFromOCR.puzzle[2][1] == 0) "" else boardFromOCR.puzzle[2][1].toString())
            et_cell_C3.setText(if(boardFromOCR.puzzle[2][2] == 0) "" else boardFromOCR.puzzle[2][2].toString())
            et_cell_C4.setText(if(boardFromOCR.puzzle[2][3] == 0) "" else boardFromOCR.puzzle[2][3].toString())
            et_cell_C5.setText(if(boardFromOCR.puzzle[2][4] == 0) "" else boardFromOCR.puzzle[2][4].toString())
            et_cell_C6.setText(if(boardFromOCR.puzzle[2][5] == 0) "" else boardFromOCR.puzzle[2][5].toString())
            et_cell_C7.setText(if(boardFromOCR.puzzle[2][6] == 0) "" else boardFromOCR.puzzle[2][6].toString())
            et_cell_C8.setText(if(boardFromOCR.puzzle[2][7] == 0) "" else boardFromOCR.puzzle[2][7].toString())
            et_cell_C9.setText(if(boardFromOCR.puzzle[2][8] == 0) "" else boardFromOCR.puzzle[2][8].toString())

            et_cell_D1.setText(if(boardFromOCR.puzzle[3][0] == 0) "" else boardFromOCR.puzzle[3][0].toString())
            et_cell_D2.setText(if(boardFromOCR.puzzle[3][1] == 0) "" else boardFromOCR.puzzle[3][1].toString())
            et_cell_D3.setText(if(boardFromOCR.puzzle[3][2] == 0) "" else boardFromOCR.puzzle[3][2].toString())
            et_cell_D4.setText(if(boardFromOCR.puzzle[3][3] == 0) "" else boardFromOCR.puzzle[3][3].toString())
            et_cell_D5.setText(if(boardFromOCR.puzzle[3][4] == 0) "" else boardFromOCR.puzzle[3][4].toString())
            et_cell_D6.setText(if(boardFromOCR.puzzle[3][5] == 0) "" else boardFromOCR.puzzle[3][5].toString())
            et_cell_D7.setText(if(boardFromOCR.puzzle[3][6] == 0) "" else boardFromOCR.puzzle[3][6].toString())
            et_cell_D8.setText(if(boardFromOCR.puzzle[3][7] == 0) "" else boardFromOCR.puzzle[3][7].toString())
            et_cell_D9.setText(if(boardFromOCR.puzzle[3][8] == 0) "" else boardFromOCR.puzzle[3][8].toString())

            et_cell_E1.setText(if(boardFromOCR.puzzle[4][0] == 0) "" else boardFromOCR.puzzle[4][0].toString())
            et_cell_E2.setText(if(boardFromOCR.puzzle[4][1] == 0) "" else boardFromOCR.puzzle[4][1].toString())
            et_cell_E3.setText(if(boardFromOCR.puzzle[4][2] == 0) "" else boardFromOCR.puzzle[4][2].toString())
            et_cell_E4.setText(if(boardFromOCR.puzzle[4][3] == 0) "" else boardFromOCR.puzzle[4][3].toString())
            et_cell_E5.setText(if(boardFromOCR.puzzle[4][4] == 0) "" else boardFromOCR.puzzle[4][4].toString())
            et_cell_E6.setText(if(boardFromOCR.puzzle[4][5] == 0) "" else boardFromOCR.puzzle[4][5].toString())
            et_cell_E7.setText(if(boardFromOCR.puzzle[4][6] == 0) "" else boardFromOCR.puzzle[4][6].toString())
            et_cell_E8.setText(if(boardFromOCR.puzzle[4][7] == 0) "" else boardFromOCR.puzzle[4][7].toString())
            et_cell_E9.setText(if(boardFromOCR.puzzle[4][8] == 0) "" else boardFromOCR.puzzle[4][8].toString())

            et_cell_F1.setText(if(boardFromOCR.puzzle[5][0] == 0) "" else boardFromOCR.puzzle[5][0].toString())
            et_cell_F2.setText(if(boardFromOCR.puzzle[5][1] == 0) "" else boardFromOCR.puzzle[5][1].toString())
            et_cell_F3.setText(if(boardFromOCR.puzzle[5][2] == 0) "" else boardFromOCR.puzzle[5][2].toString())
            et_cell_F4.setText(if(boardFromOCR.puzzle[5][3] == 0) "" else boardFromOCR.puzzle[5][3].toString())
            et_cell_F5.setText(if(boardFromOCR.puzzle[5][4] == 0) "" else boardFromOCR.puzzle[5][4].toString())
            et_cell_F6.setText(if(boardFromOCR.puzzle[5][5] == 0) "" else boardFromOCR.puzzle[5][5].toString())
            et_cell_F7.setText(if(boardFromOCR.puzzle[5][6] == 0) "" else boardFromOCR.puzzle[5][6].toString())
            et_cell_F8.setText(if(boardFromOCR.puzzle[5][7] == 0) "" else boardFromOCR.puzzle[5][7].toString())
            et_cell_F9.setText(if(boardFromOCR.puzzle[5][8] == 0) "" else boardFromOCR.puzzle[5][8].toString())

            et_cell_G1.setText(if(boardFromOCR.puzzle[6][0] == 0) "" else boardFromOCR.puzzle[6][0].toString())
            et_cell_G2.setText(if(boardFromOCR.puzzle[6][1] == 0) "" else boardFromOCR.puzzle[6][1].toString())
            et_cell_G3.setText(if(boardFromOCR.puzzle[6][2] == 0) "" else boardFromOCR.puzzle[6][2].toString())
            et_cell_G4.setText(if(boardFromOCR.puzzle[6][3] == 0) "" else boardFromOCR.puzzle[6][3].toString())
            et_cell_G5.setText(if(boardFromOCR.puzzle[6][4] == 0) "" else boardFromOCR.puzzle[6][4].toString())
            et_cell_G6.setText(if(boardFromOCR.puzzle[6][5] == 0) "" else boardFromOCR.puzzle[6][5].toString())
            et_cell_G7.setText(if(boardFromOCR.puzzle[6][6] == 0) "" else boardFromOCR.puzzle[6][6].toString())
            et_cell_G8.setText(if(boardFromOCR.puzzle[6][7] == 0) "" else boardFromOCR.puzzle[6][7].toString())
            et_cell_G9.setText(if(boardFromOCR.puzzle[6][8] == 0) "" else boardFromOCR.puzzle[6][8].toString())

            et_cell_H1.setText(if(boardFromOCR.puzzle[7][0] == 0) "" else boardFromOCR.puzzle[7][0].toString())
            et_cell_H2.setText(if(boardFromOCR.puzzle[7][1] == 0) "" else boardFromOCR.puzzle[7][1].toString())
            et_cell_H3.setText(if(boardFromOCR.puzzle[7][2] == 0) "" else boardFromOCR.puzzle[7][2].toString())
            et_cell_H4.setText(if(boardFromOCR.puzzle[7][3] == 0) "" else boardFromOCR.puzzle[7][3].toString())
            et_cell_H5.setText(if(boardFromOCR.puzzle[7][4] == 0) "" else boardFromOCR.puzzle[7][4].toString())
            et_cell_H6.setText(if(boardFromOCR.puzzle[7][5] == 0) "" else boardFromOCR.puzzle[7][5].toString())
            et_cell_H7.setText(if(boardFromOCR.puzzle[7][6] == 0) "" else boardFromOCR.puzzle[7][6].toString())
            et_cell_H8.setText(if(boardFromOCR.puzzle[7][7] == 0) "" else boardFromOCR.puzzle[7][7].toString())
            et_cell_H9.setText(if(boardFromOCR.puzzle[7][8] == 0) "" else boardFromOCR.puzzle[7][8].toString())

            et_cell_I1.setText(if(boardFromOCR.puzzle[8][0] == 0) "" else boardFromOCR.puzzle[8][0].toString())
            et_cell_I2.setText(if(boardFromOCR.puzzle[8][1] == 0) "" else boardFromOCR.puzzle[8][1].toString())
            et_cell_I3.setText(if(boardFromOCR.puzzle[8][2] == 0) "" else boardFromOCR.puzzle[8][2].toString())
            et_cell_I4.setText(if(boardFromOCR.puzzle[8][3] == 0) "" else boardFromOCR.puzzle[8][3].toString())
            et_cell_I5.setText(if(boardFromOCR.puzzle[8][4] == 0) "" else boardFromOCR.puzzle[8][4].toString())
            et_cell_I6.setText(if(boardFromOCR.puzzle[8][5] == 0) "" else boardFromOCR.puzzle[8][5].toString())
            et_cell_I7.setText(if(boardFromOCR.puzzle[8][6] == 0) "" else boardFromOCR.puzzle[8][6].toString())
            et_cell_I8.setText(if(boardFromOCR.puzzle[8][7] == 0) "" else boardFromOCR.puzzle[8][7].toString())
            et_cell_I9.setText(if(boardFromOCR.puzzle[8][8] == 0) "" else boardFromOCR.puzzle[8][8].toString())
        }

        btnSolve.setOnClickListener {
            val puzzle = listOf<List<Int>>(
                listOf<Int>(
                    if (et_cell_A1.text.isNotBlank()) et_cell_A1.text.toString().toInt() else 0,
                    if (et_cell_A2.text.isNotBlank()) et_cell_A2.text.toString().toInt() else 0,
                    if (et_cell_A3.text.isNotBlank()) et_cell_A3.text.toString().toInt() else 0,
                    if (et_cell_A4.text.isNotBlank()) et_cell_A4.text.toString().toInt() else 0,
                    if (et_cell_A5.text.isNotBlank()) et_cell_A5.text.toString().toInt() else 0,
                    if (et_cell_A6.text.isNotBlank()) et_cell_A6.text.toString().toInt() else 0,
                    if (et_cell_A7.text.isNotBlank()) et_cell_A7.text.toString().toInt() else 0,
                    if (et_cell_A8.text.isNotBlank()) et_cell_A8.text.toString().toInt() else 0,
                    if (et_cell_A9.text.isNotBlank()) et_cell_A9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_B1.text.isNotBlank()) et_cell_B1.text.toString().toInt() else 0,
                    if (et_cell_B2.text.isNotBlank()) et_cell_B2.text.toString().toInt() else 0,
                    if (et_cell_B3.text.isNotBlank()) et_cell_B3.text.toString().toInt() else 0,
                    if (et_cell_B4.text.isNotBlank()) et_cell_B4.text.toString().toInt() else 0,
                    if (et_cell_B5.text.isNotBlank()) et_cell_B5.text.toString().toInt() else 0,
                    if (et_cell_B6.text.isNotBlank()) et_cell_B6.text.toString().toInt() else 0,
                    if (et_cell_B7.text.isNotBlank()) et_cell_B7.text.toString().toInt() else 0,
                    if (et_cell_B8.text.isNotBlank()) et_cell_B8.text.toString().toInt() else 0,
                    if (et_cell_B9.text.isNotBlank()) et_cell_B9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_C1.text.isNotBlank()) et_cell_C1.text.toString().toInt() else 0,
                    if (et_cell_C2.text.isNotBlank()) et_cell_C2.text.toString().toInt() else 0,
                    if (et_cell_C3.text.isNotBlank()) et_cell_C3.text.toString().toInt() else 0,
                    if (et_cell_C4.text.isNotBlank()) et_cell_C4.text.toString().toInt() else 0,
                    if (et_cell_C5.text.isNotBlank()) et_cell_C5.text.toString().toInt() else 0,
                    if (et_cell_C6.text.isNotBlank()) et_cell_C6.text.toString().toInt() else 0,
                    if (et_cell_C7.text.isNotBlank()) et_cell_C7.text.toString().toInt() else 0,
                    if (et_cell_C8.text.isNotBlank()) et_cell_C8.text.toString().toInt() else 0,
                    if (et_cell_C9.text.isNotBlank()) et_cell_C9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_D1.text.isNotBlank())et_cell_D1.text.toString().toInt() else 0,
                    if (et_cell_D2.text.isNotBlank())et_cell_D2.text.toString().toInt() else 0,
                    if (et_cell_D3.text.isNotBlank())et_cell_D3.text.toString().toInt() else 0,
                    if (et_cell_D4.text.isNotBlank())et_cell_D4.text.toString().toInt() else 0,
                    if (et_cell_D5.text.isNotBlank())et_cell_D5.text.toString().toInt() else 0,
                    if (et_cell_D6.text.isNotBlank())et_cell_D6.text.toString().toInt() else 0,
                    if (et_cell_D7.text.isNotBlank())et_cell_D7.text.toString().toInt() else 0,
                    if (et_cell_D8.text.isNotBlank())et_cell_D8.text.toString().toInt() else 0,
                    if (et_cell_D9.text.isNotBlank())et_cell_D9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_E1.text.isNotBlank()) et_cell_E1.text.toString().toInt() else 0,
                    if (et_cell_E2.text.isNotBlank()) et_cell_E2.text.toString().toInt() else 0,
                    if (et_cell_E3.text.isNotBlank()) et_cell_E3.text.toString().toInt() else 0,
                    if (et_cell_E4.text.isNotBlank()) et_cell_E4.text.toString().toInt() else 0,
                    if (et_cell_E5.text.isNotBlank()) et_cell_E5.text.toString().toInt() else 0,
                    if (et_cell_E6.text.isNotBlank()) et_cell_E6.text.toString().toInt() else 0,
                    if (et_cell_E7.text.isNotBlank()) et_cell_E7.text.toString().toInt() else 0,
                    if (et_cell_E8.text.isNotBlank()) et_cell_E8.text.toString().toInt() else 0,
                    if (et_cell_E9.text.isNotBlank()) et_cell_E9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_F1.text.isNotBlank()) et_cell_F1.text.toString().toInt() else 0,
                    if (et_cell_F2.text.isNotBlank()) et_cell_F2.text.toString().toInt() else 0,
                    if (et_cell_F3.text.isNotBlank()) et_cell_F3.text.toString().toInt() else 0,
                    if (et_cell_F4.text.isNotBlank()) et_cell_F4.text.toString().toInt() else 0,
                    if (et_cell_F5.text.isNotBlank()) et_cell_F5.text.toString().toInt() else 0,
                    if (et_cell_F6.text.isNotBlank()) et_cell_F6.text.toString().toInt() else 0,
                    if (et_cell_F7.text.isNotBlank()) et_cell_F7.text.toString().toInt() else 0,
                    if (et_cell_F8.text.isNotBlank()) et_cell_F8.text.toString().toInt() else 0,
                    if (et_cell_F9.text.isNotBlank()) et_cell_F9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_G1.text.isNotBlank()) et_cell_G1.text.toString().toInt() else 0,
                    if (et_cell_G2.text.isNotBlank()) et_cell_G2.text.toString().toInt() else 0,
                    if (et_cell_G3.text.isNotBlank()) et_cell_G3.text.toString().toInt() else 0,
                    if (et_cell_G4.text.isNotBlank()) et_cell_G4.text.toString().toInt() else 0,
                    if (et_cell_G5.text.isNotBlank()) et_cell_G5.text.toString().toInt() else 0,
                    if (et_cell_G6.text.isNotBlank()) et_cell_G6.text.toString().toInt() else 0,
                    if (et_cell_G7.text.isNotBlank()) et_cell_G7.text.toString().toInt() else 0,
                    if (et_cell_G8.text.isNotBlank()) et_cell_G8.text.toString().toInt() else 0,
                    if (et_cell_G9.text.isNotBlank()) et_cell_G9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_H1.text.isNotBlank()) et_cell_H1.text.toString().toInt() else 0,
                    if (et_cell_H2.text.isNotBlank()) et_cell_H2.text.toString().toInt() else 0,
                    if (et_cell_H3.text.isNotBlank()) et_cell_H3.text.toString().toInt() else 0,
                    if (et_cell_H4.text.isNotBlank()) et_cell_H4.text.toString().toInt() else 0,
                    if (et_cell_H5.text.isNotBlank()) et_cell_H5.text.toString().toInt() else 0,
                    if (et_cell_H6.text.isNotBlank()) et_cell_H6.text.toString().toInt() else 0,
                    if (et_cell_H7.text.isNotBlank()) et_cell_H7.text.toString().toInt() else 0,
                    if (et_cell_H8.text.isNotBlank()) et_cell_H8.text.toString().toInt() else 0,
                    if (et_cell_H9.text.isNotBlank()) et_cell_H9.text.toString().toInt() else 0
                ),
                listOf<Int>(
                    if (et_cell_I1.text.isNotBlank()) et_cell_I1.text.toString().toInt() else 0,
                    if (et_cell_I2.text.isNotBlank()) et_cell_I2.text.toString().toInt() else 0,
                    if (et_cell_I3.text.isNotBlank()) et_cell_I3.text.toString().toInt() else 0,
                    if (et_cell_I4.text.isNotBlank()) et_cell_I4.text.toString().toInt() else 0,
                    if (et_cell_I5.text.isNotBlank()) et_cell_I5.text.toString().toInt() else 0,
                    if (et_cell_I6.text.isNotBlank()) et_cell_I6.text.toString().toInt() else 0,
                    if (et_cell_I7.text.isNotBlank()) et_cell_I7.text.toString().toInt() else 0,
                    if (et_cell_I8.text.isNotBlank()) et_cell_I8.text.toString().toInt() else 0,
                    if (et_cell_I9.text.isNotBlank()) et_cell_I9.text.toString().toInt() else 0
                )
            )
            val board = Board(puzzle)
            Log.e("[POST][SOLVE]", "board = $board")
            GlobalScope.launch(Dispatchers.Main) {
                pbSolve.isVisible = true
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
                finally {
                    pbSolve.isVisible = false
                }
                Log.e("[POST][SOLVE][response]", "response: $response \nresponse body: ${response.body()}")


                if (response.isSuccessful && response.body() != null && response.body()!!.error.isEmpty()){
                    val solvedPuzzle = response.body()!!.solved_puzzle
                    et_cell_A1.setText(solvedPuzzle[0][0].toString())
                    et_cell_A2.setText(solvedPuzzle[0][1].toString())
                    et_cell_A3.setText(solvedPuzzle[0][2].toString())
                    et_cell_A4.setText(solvedPuzzle[0][3].toString())
                    et_cell_A5.setText(solvedPuzzle[0][4].toString())
                    et_cell_A6.setText(solvedPuzzle[0][5].toString())
                    et_cell_A7.setText(solvedPuzzle[0][6].toString())
                    et_cell_A8.setText(solvedPuzzle[0][7].toString())
                    et_cell_A9.setText(solvedPuzzle[0][8].toString())

                    et_cell_B1.setText(solvedPuzzle[1][0].toString())
                    et_cell_B2.setText(solvedPuzzle[1][1].toString())
                    et_cell_B3.setText(solvedPuzzle[1][2].toString())
                    et_cell_B4.setText(solvedPuzzle[1][3].toString())
                    et_cell_B5.setText(solvedPuzzle[1][4].toString())
                    et_cell_B6.setText(solvedPuzzle[1][5].toString())
                    et_cell_B7.setText(solvedPuzzle[1][6].toString())
                    et_cell_B8.setText(solvedPuzzle[1][7].toString())
                    et_cell_B9.setText(solvedPuzzle[1][8].toString())

                    et_cell_C1.setText(solvedPuzzle[2][0].toString())
                    et_cell_C2.setText(solvedPuzzle[2][1].toString())
                    et_cell_C3.setText(solvedPuzzle[2][2].toString())
                    et_cell_C4.setText(solvedPuzzle[2][3].toString())
                    et_cell_C5.setText(solvedPuzzle[2][4].toString())
                    et_cell_C6.setText(solvedPuzzle[2][5].toString())
                    et_cell_C7.setText(solvedPuzzle[2][6].toString())
                    et_cell_C8.setText(solvedPuzzle[2][7].toString())
                    et_cell_C9.setText(solvedPuzzle[2][8].toString())

                    et_cell_D1.setText(solvedPuzzle[3][0].toString())
                    et_cell_D2.setText(solvedPuzzle[3][1].toString())
                    et_cell_D3.setText(solvedPuzzle[3][2].toString())
                    et_cell_D4.setText(solvedPuzzle[3][3].toString())
                    et_cell_D5.setText(solvedPuzzle[3][4].toString())
                    et_cell_D6.setText(solvedPuzzle[3][5].toString())
                    et_cell_D7.setText(solvedPuzzle[3][6].toString())
                    et_cell_D8.setText(solvedPuzzle[3][7].toString())
                    et_cell_D9.setText(solvedPuzzle[3][8].toString())

                    et_cell_E1.setText(solvedPuzzle[4][0].toString())
                    et_cell_E2.setText(solvedPuzzle[4][1].toString())
                    et_cell_E3.setText(solvedPuzzle[4][2].toString())
                    et_cell_E4.setText(solvedPuzzle[4][3].toString())
                    et_cell_E5.setText(solvedPuzzle[4][4].toString())
                    et_cell_E6.setText(solvedPuzzle[4][5].toString())
                    et_cell_E7.setText(solvedPuzzle[4][6].toString())
                    et_cell_E8.setText(solvedPuzzle[4][7].toString())
                    et_cell_E9.setText(solvedPuzzle[4][8].toString())

                    et_cell_F1.setText(solvedPuzzle[5][0].toString())
                    et_cell_F2.setText(solvedPuzzle[5][1].toString())
                    et_cell_F3.setText(solvedPuzzle[5][2].toString())
                    et_cell_F4.setText(solvedPuzzle[5][3].toString())
                    et_cell_F5.setText(solvedPuzzle[5][4].toString())
                    et_cell_F6.setText(solvedPuzzle[5][5].toString())
                    et_cell_F7.setText(solvedPuzzle[5][6].toString())
                    et_cell_F8.setText(solvedPuzzle[5][7].toString())
                    et_cell_F9.setText(solvedPuzzle[5][8].toString())

                    et_cell_G1.setText(solvedPuzzle[6][0].toString())
                    et_cell_G2.setText(solvedPuzzle[6][1].toString())
                    et_cell_G3.setText(solvedPuzzle[6][2].toString())
                    et_cell_G4.setText(solvedPuzzle[6][3].toString())
                    et_cell_G5.setText(solvedPuzzle[6][4].toString())
                    et_cell_G6.setText(solvedPuzzle[6][5].toString())
                    et_cell_G7.setText(solvedPuzzle[6][6].toString())
                    et_cell_G8.setText(solvedPuzzle[6][7].toString())
                    et_cell_G9.setText(solvedPuzzle[6][8].toString())

                    et_cell_H1.setText(solvedPuzzle[7][0].toString())
                    et_cell_H2.setText(solvedPuzzle[7][1].toString())
                    et_cell_H3.setText(solvedPuzzle[7][2].toString())
                    et_cell_H4.setText(solvedPuzzle[7][3].toString())
                    et_cell_H5.setText(solvedPuzzle[7][4].toString())
                    et_cell_H6.setText(solvedPuzzle[7][5].toString())
                    et_cell_H7.setText(solvedPuzzle[7][6].toString())
                    et_cell_H8.setText(solvedPuzzle[7][7].toString())
                    et_cell_H9.setText(solvedPuzzle[7][8].toString())

                    et_cell_I1.setText(solvedPuzzle[8][0].toString())
                    et_cell_I2.setText(solvedPuzzle[8][1].toString())
                    et_cell_I3.setText(solvedPuzzle[8][2].toString())
                    et_cell_I4.setText(solvedPuzzle[8][3].toString())
                    et_cell_I5.setText(solvedPuzzle[8][4].toString())
                    et_cell_I6.setText(solvedPuzzle[8][5].toString())
                    et_cell_I7.setText(solvedPuzzle[8][6].toString())
                    et_cell_I8.setText(solvedPuzzle[8][7].toString())
                    et_cell_I9.setText(solvedPuzzle[8][8].toString())
                }
                else {
                    Toast.makeText(applicationContext, response.body()!!.error, Toast.LENGTH_LONG).show()
                }
            }
        }

        btnClear.setOnClickListener {
            et_cell_A1.setText("")
            et_cell_A2.setText("")
            et_cell_A3.setText("")
            et_cell_A4.setText("")
            et_cell_A5.setText("")
            et_cell_A6.setText("")
            et_cell_A7.setText("")
            et_cell_A8.setText("")
            et_cell_A9.setText("")

            et_cell_B1.setText("")
            et_cell_B2.setText("")
            et_cell_B3.setText("")
            et_cell_B4.setText("")
            et_cell_B5.setText("")
            et_cell_B6.setText("")
            et_cell_B7.setText("")
            et_cell_B8.setText("")
            et_cell_B9.setText("")

            et_cell_C1.setText("")
            et_cell_C2.setText("")
            et_cell_C3.setText("")
            et_cell_C4.setText("")
            et_cell_C5.setText("")
            et_cell_C6.setText("")
            et_cell_C7.setText("")
            et_cell_C8.setText("")
            et_cell_C9.setText("")

            et_cell_D1.setText("")
            et_cell_D2.setText("")
            et_cell_D3.setText("")
            et_cell_D4.setText("")
            et_cell_D5.setText("")
            et_cell_D6.setText("")
            et_cell_D7.setText("")
            et_cell_D8.setText("")
            et_cell_D9.setText("")

            et_cell_E1.setText("")
            et_cell_E2.setText("")
            et_cell_E3.setText("")
            et_cell_E4.setText("")
            et_cell_E5.setText("")
            et_cell_E6.setText("")
            et_cell_E7.setText("")
            et_cell_E8.setText("")
            et_cell_E9.setText("")

            et_cell_F1.setText("")
            et_cell_F2.setText("")
            et_cell_F3.setText("")
            et_cell_F4.setText("")
            et_cell_F5.setText("")
            et_cell_F6.setText("")
            et_cell_F7.setText("")
            et_cell_F8.setText("")
            et_cell_F9.setText("")

            et_cell_G1.setText("")
            et_cell_G2.setText("")
            et_cell_G3.setText("")
            et_cell_G4.setText("")
            et_cell_G5.setText("")
            et_cell_G6.setText("")
            et_cell_G7.setText("")
            et_cell_G8.setText("")
            et_cell_G9.setText("")

            et_cell_H1.setText("")
            et_cell_H2.setText("")
            et_cell_H3.setText("")
            et_cell_H4.setText("")
            et_cell_H5.setText("")
            et_cell_H6.setText("")
            et_cell_H7.setText("")
            et_cell_H8.setText("")
            et_cell_H9.setText("")

            et_cell_I1.setText("")
            et_cell_I2.setText("")
            et_cell_I3.setText("")
            et_cell_I4.setText("")
            et_cell_I5.setText("")
            et_cell_I6.setText("")
            et_cell_I7.setText("")
            et_cell_I8.setText("")
            et_cell_I9.setText("")
        }
    }
}