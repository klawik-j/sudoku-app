package com.example.sudoku_app

import java.io.Serializable

data class Board(
    val puzzle: List<List<Int>>
) : Serializable