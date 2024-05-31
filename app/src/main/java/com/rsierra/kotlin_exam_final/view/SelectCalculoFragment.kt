package com.rsierra.kotlin_exam_final.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsierra.kotlin_exam_final.R
import com.rsierra.kotlin_exam_final.adapter.CalculoAdapter
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import com.rsierra.kotlin_exam_final.databinding.FragmentSelectCalculoBinding
import com.rsierra.kotlin_exam_final.deleteCalculoDialog
import com.rsierra.kotlin_exam_final.interfaces.CalculoClickListener
import com.rsierra.kotlin_exam_final.viewModel.SelectViewModel


class SelectCalculoFragment : Fragment(), CalculoClickListener {
    lateinit var binding: FragmentSelectCalculoBinding
    lateinit var viewModel: SelectViewModel
    val adapter = CalculoAdapter(arrayListOf(), this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectCalculoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SelectViewModel::class.java)
        binding.rvMascotas.adapter = adapter
        binding.rvMascotas.layoutManager = LinearLayoutManager(context)
        viewModel.calculo.observe(viewLifecycleOwner) { newList ->
            Log.d("TEST", "${newList.size}")
            adapter.loadNewItems(newList)
        }
        viewModel.loadCalculos()
        binding.btnCalculadora.setOnClickListener {
            findNavController().navigate(R.id.action_selectCalculoFragment2_to_insertCalculoFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onClick(calculo: Calculo) {
        context?.let { ctx ->
            deleteCalculoDialog(ctx,
                calculo,
                { calculo ->
                    viewModel.deleteCalculos(calculo, adapter)
                })
        }
    }
}