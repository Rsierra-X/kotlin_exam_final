package com.rsierra.kotlin_exam_final

import android.app.AlertDialog
import android.content.Context
import com.rsierra.kotlin_exam_final.database.entities.Calculo

fun deleteCalculoDialog(context: Context,
                        calculo: Calculo,
                        borrar: (Calculo) -> Unit
) {
    val dialogo = AlertDialog.Builder(context)
    dialogo.setTitle(context.resources.getString(R.string.delete_calculo_titulo))
    dialogo.setMessage("Eliminar ${calculo.operator_1} ${calculo.operator} ${calculo.operator_2}?")
    dialogo.setPositiveButton("BORRAR") { d, _ ->
        borrar(calculo)
    }
    dialogo.setNeutralButton("CANCELAR") {d, _ ->
        d.dismiss()
    }
    dialogo.show()
}
