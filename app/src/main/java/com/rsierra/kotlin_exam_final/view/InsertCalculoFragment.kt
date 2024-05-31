package com.rsierra.kotlin_exam_final.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rsierra.kotlin_exam_final.R
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import com.rsierra.kotlin_exam_final.databinding.FragmentInsertCalculoBinding
import com.rsierra.kotlin_exam_final.viewModel.InsertCalculoViewModel


class InsertCalculoFragment : Fragment() {

    lateinit var binding : FragmentInsertCalculoBinding;
    lateinit var viewModel: InsertCalculoViewModel
    var items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertCalculoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InsertCalculoViewModel::class.java)
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_add -> viewModel.onRadioButtonClicked("+")
                R.id.radio_subtract -> viewModel.onRadioButtonClicked("-")
                R.id.radio_multiply -> viewModel.onRadioButtonClicked("*")
                R.id.radio_divide -> viewModel.onRadioButtonClicked("/")
            }
        }
        binding.btnGrabar.setOnClickListener {
            try {
                var opt1 = binding.op1.text.toString().toFloat()
                var opt2 = binding.op2.text.toString().toFloat()
                val operador = viewModel.getSelectedOperation();
                var result = getResult(opt1,opt2,operador)
                val calculo = Calculo(
                    operator_1 = opt1,
                    operator_2 = opt2,
                    operator = operador,
                    result = result
                )
                binding.op1.text.clear()
                binding.op2.text.clear()
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