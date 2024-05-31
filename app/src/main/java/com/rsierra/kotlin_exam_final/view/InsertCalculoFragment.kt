package com.rsierra.kotlin_exam_final.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rsierra.kotlin_exam_final.R
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import com.rsierra.kotlin_exam_final.databinding.FragmentInsertCalculoBinding
import com.rsierra.kotlin_exam_final.viewModel.InsertCalculoViewModel


class InsertCalculoFragment : Fragment() {

    lateinit var binding : FragmentInsertCalculoBinding;
    lateinit var viewModel: InsertCalculoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertCalculoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InsertCalculoViewModel::class.java)
        binding.btnGrabar.setOnClickListener {
            try {
                var opt1 = binding.op1.text.toString().toFloat()
                var opt2 = binding.op2.text.toString().toFloat()
                val operador = binding.operador.text.toString();
                var result = getResult(opt1,opt2,operador)
                val calculo = Calculo(
                    operator_1 = opt1,
                    operator_2 = opt2,
                    operator = operador,
                    result = result
                )
                binding.op1.text.clear()
                binding.op2.text.clear()
                binding.operador.text.clear()
                viewModel.save(calculo)
            }catch (_: NumberFormatException){ }
        }
        binding.btnListado.setOnClickListener {
            findNavController().navigate(R.id.action_insertCalculoFragment_to_selectCalculoFragment2)
        }
        return binding.root
    }

    private fun getResult(opt1: Float, opt2: Float, operador: String): Float {
        return when (operador) {
            "+" -> return opt1 + opt2
            "-" -> return opt1 - opt2
            "*" -> return opt1 * opt2
            "/" -> return opt1 / opt2
            else -> Float.MIN_VALUE
        }
    }

}