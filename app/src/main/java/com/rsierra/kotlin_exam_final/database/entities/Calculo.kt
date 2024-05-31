package com.rsierra.kotlin_exam_final.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculo")
data class Calculo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val operator_1: Float,
    val operator_2: Float,
    val operator: String,
    val result: Float
)
