package com.rsierra.kotlin_exam_final.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rsierra.kotlin_exam_final.MyApplication
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import kotlinx.coroutines.launch

class InsertCalculoViewModel(val app: Application): AndroidViewModel(app) {
    fun save(calculos: Calculo) {
        viewModelScope.launch {
            (app as MyApplication).database.getCalulosDao().insertCalculo(calculos)
        }
    }
}