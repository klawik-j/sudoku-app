package com.example.sudoku_app

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.net.Uri
import android.os.Environment
import android.os.FileUtils
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest


class OcrActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var btnTakePhoto: Button
    private lateinit var btnUpload: Button
    private lateinit var ivBoard: ImageView
    private lateinit var pbOCR: ProgressBar
    lateinit var currentPhotoPath: String
    private lateinit var photoFile: File
    private lateinit var board: Board
    private var boardFound: Boolean = false
    val FILE_NAME = "photo."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ocr)
        btnTakePhoto = findViewById(R.id.btnTakePhoto)
        btnUpload = findViewById(R.id.btnUpload)
        ivBoard = findViewById(R.id.ivBoard)
        pbOCR = findViewById(R.id.pbOCR)

        btnTakePhoto.setOnClickListener {
            dispatchTakePictureIntent()
        }

        btnUpload.setOnClickListener {
            var requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), photoFile)
            var body: MultipartBody.Part = MultipartBody.Part.createFormData("image", "image.jpg", requestFile)
            GlobalScope.launch(Dispatchers.Main) {
                pbOCR.isVisible = true
                val response = try {
                    RetrofitInstance.api.postBoardPhoto(body)
                } catch (e: IOException) {
                    Log.e("[POST][OCR]", "IOException: ${e.message}")
                    return@launch
                } catch (e: HttpException) {
                    Log.e("[POST][OCR]", "HttpException: ${e.message}")
                    return@launch
                } catch (e: Exception) {
                    Log.e("[POST][OCR]", "Exception: ${e.message}")
                    return@launch
                } finally {
                    pbOCR.isVisible = false
                }
                Log.e(
                    "[POST][OCR][response]",
                    "response: $response \nresponse body: ${response.body()}"
                )
                if (response.isSuccessful && response.body() != null && response.body()!!.error.isEmpty()){
                    board = Board(response.body()!!.puzzle)
                    boardFound = true
                    Intent(this@OcrActivity, SolveActivity::class.java).also {
                        it.putExtra("EXTRA_board", board)
                        it.putExtra("EXTRA_boardFound", boardFound)
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(applicationContext, response.body()!!.error, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getPhotoFile(fileName: String): File{
        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }


    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFile(FILE_NAME)

        //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile)

        val fileProvider = FileProvider.getUriForFile(this, "com.example.sudoku_app.fileprovider", photoFile)
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Log.e("[OCR][take picture]", "${e.message}")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            ivBoard.setImageBitmap(takenImage)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    /*private fun dispatchTakePictureIntent() {
        Log.e("[TakePictureIntent]", "click !")
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    Log.e("[OCR][create file]", "${ex.message}")
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.android.fileprovider",
                        it
                    )
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }*/

    /*@Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",  prefix
            ".jpg",  suffix
            storageDir  directory
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }*/

    /*private fun galleryAddPic() {
        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
            val f = File(currentPhotoPath)
            mediaScanIntent.data = Uri.fromFile(f)
            sendBroadcast(mediaScanIntent)
        }
    }*/

}