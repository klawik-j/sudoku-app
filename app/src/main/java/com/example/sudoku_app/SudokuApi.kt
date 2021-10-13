package com.example.sudoku_app

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SudokuApi {
    @POST("/api/solve/")
    suspend fun postBoard(@Body board: Board): Response<SolveResponse>

    @GET("/account")
    suspend fun getAccounts(): Response<List<Account>>
}