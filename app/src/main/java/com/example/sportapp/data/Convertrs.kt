package com.example.sportapp.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Convertrs {
    @TypeConverter
    fun toBitmap(arr: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(arr, 0, arr.size)

    }

    @TypeConverter
    fun toByteArray(bmp: Bitmap): ByteArray {
        val outStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream)
        return outStream.toByteArray()
    }
}