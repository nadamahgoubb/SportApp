package com.example.sportapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportapp.data.entitiy.Run

@Database(entities = [Run::class ],version = 1)
@TypeConverters(Convertrs::class)
abstract class RunDataBase : RoomDatabase() {
    abstract  fun getDao():RunDAO
}