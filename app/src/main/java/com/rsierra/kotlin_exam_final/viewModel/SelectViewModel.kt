package com.rsierra.kotlin_exam_final.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rsierra.kotlin_exam_final.MyApplication
import com.rsierra.kotlin_exam_final.adapter.CalculoAdapter
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import kotlinx.coroutines.launch

class SelectViewModel (val app: Application): AndroidViewModel(app) {
    private val _calculos: MutableLiveData<List<Calculo>> = MutableLiveData(emptyList())
    val calculo: LiveData<List<Calculo>> = _calculos

    fun loadCalculos() {
        viewModelScope.launch {
            val arrayData = (app as MyApplication).database.getCalulosDao().getAllCalculos()
            _calculos.postValue(arrayData)
        }
    }

    fun deleteCalculos(calculo: Calculo, adapter: CalculoAdapter) {
        adapter.deleteItem(calculo)
        viewModelScope.launch {
            (app as MyApplication).database.getCalulosDao().deleteCalculo(calculo)
        }
    }

}