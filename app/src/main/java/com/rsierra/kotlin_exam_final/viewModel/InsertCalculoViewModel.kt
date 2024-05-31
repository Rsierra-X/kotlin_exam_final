package com.rsierra.kotlin_exam_final.viewModel

import android.R
import android.app.Application
import android.content.Context
import android.widget.ArrayAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rsierra.kotlin_exam_final.MyApplication
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import kotlinx.coroutines.launch


class InsertCalculoViewModel(val app: Application): AndroidViewModel(app) {
    val selectedOperation = ObservableField<String>("")

    fun onRadioButtonClicked(operation: String) {
        selectedOperation.set(operation)
    }

    fun getSelectedOperation(): String {
        return selectedOperation.get() ?: ""
    }
    fun save(calculos: Calculo) {
        viewModelScope.launch {
            (app as MyApplication).database.getCalulosDao().insertCalculo(calculos)
        }
    }

}