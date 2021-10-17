package com.example.sudoku_app

data class SolveResponse(
    val solved_puzzle: List<List<Int>>,
    val error: String
)
