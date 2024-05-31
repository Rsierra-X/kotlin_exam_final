package com.rsierra.kotlin_exam_final

import android.app.Application
import com.rsierra.kotlin_exam_final.database.MyDatabase

class MyApplication: Application() {
    lateinit var database: MyDatabase
    override fun onCreate() {
        super.onCreate()
        database = MyDatabase.buildDatabase(this)
    }
}