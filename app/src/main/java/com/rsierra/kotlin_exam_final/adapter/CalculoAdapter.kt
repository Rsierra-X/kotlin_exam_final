package com.rsierra.kotlin_exam_final.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rsierra.kotlin_exam_final.database.entities.Calculo
import com.rsierra.kotlin_exam_final.databinding.CalculoItemBinding
import com.rsierra.kotlin_exam_final.interfaces.CalculoClickListener

class CalculoAdapter(val list: ArrayList<Calculo>, val calculoListener: CalculoClickListener):
    RecyclerView.Adapter<CalculoAdapter.CalculoViewHolder>() {
    class CalculoViewHolder(val binding: CalculoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CalculoViewHolder(CalculoItemBinding
            .inflate(LayoutInflater.from(parent.context),parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CalculoViewHolder, position: Int) {
        holder.binding.nombre.text = list.get(position).operator_1.toString()
        holder.binding.raza.text = list.get(position).operator_2.toString()
        holder.binding.root.setOnClickListener {
            calculoListener.onClick(list.get(position))
        }
    }

    fun loadNewItems(newList: List<Calculo>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun deleteItem(calculo: Calculo) {
        list.remove(calculo)
        notifyDataSetChanged()
    }

    fun updateItem(calculo: Calculo) {
        val calculoOld = list.filter { m -> m.id == calculo.id}.get(0)
        list.remove(calculoOld)
        list.add(calculo)
        notifyDataSetChanged()
    }

}