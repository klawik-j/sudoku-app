import com.example.sudoku_app.Account
import com.example.sudoku_app.Board
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SudokuApi {
    @POST("/api/solve")
    fun postBoard(@Body board: Board): Response<Board>

    @GET("/account")
    fun getAccounts(): Response<List<Account>>
}