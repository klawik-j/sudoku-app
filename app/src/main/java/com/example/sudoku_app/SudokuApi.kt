package com.example.sudoku_app

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*
import java.io.File

interface SudokuApi {
    @POST("/api/solve/")
    suspend fun postBoard(@Body board: Board): Response<SolveResponse>

    @Multipart
    @POST("/api/ocr/")
    suspend fun postBoardPhoto(@Part image: MultipartBody.Part): Response<OCRResponse>

    @GET("/account")
    suspend fun getAccounts(): Response<List<Account>>
}