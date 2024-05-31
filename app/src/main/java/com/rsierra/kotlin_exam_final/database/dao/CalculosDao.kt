package com.rsierra.kotlin_exam_final.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rsierra.kotlin_exam_final.database.entities.Calculo

@Dao
interface CalculosDao {
    @Query("Select * from calculo")
    suspend fun getAllCalculos(): List<Calculo>

    @Insert
    suspend fun insertCalculo(calculo: Calculo)

    @Delete
    suspend fun deleteCalculo(calculo: Calculo)
}