package com.rsierra.kotlin_exam_final.interfaces

import com.rsierra.kotlin_exam_final.database.entities.Calculo

interface CalculoClickListener {
    fun onClick(calculo: Calculo)
}