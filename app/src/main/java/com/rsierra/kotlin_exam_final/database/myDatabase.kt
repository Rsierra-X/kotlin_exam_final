package com.rsierra.kotlin_exam_final.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rsierra.kotlin_exam_final.database.dao.CalculosDao
import com.rsierra.kotlin_exam_final.database.entities.Calculo


const val DATABASE_VERSION = 1
const val DATABASE_NAME = "calculadora"

@Database(
    entities = [Calculo::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getCalulosDao() : CalculosDao

    companion object {
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}