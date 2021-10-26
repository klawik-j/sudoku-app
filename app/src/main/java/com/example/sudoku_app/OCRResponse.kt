package com.example.sudoku_app

data class OCRResponse (
    val puzzle: List<List<Int>>,
    val error: String
    )