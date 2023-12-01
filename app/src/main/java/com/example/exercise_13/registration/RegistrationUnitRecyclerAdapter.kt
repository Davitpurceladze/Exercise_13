package com.example.exercise_13.registration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_13.databinding.RegistrationUnitBinding

class RegistrationUnitRecyclerAdapter :
    RecyclerView.Adapter<RegistrationUnitRecyclerAdapter.RecyclerViewHolder>() {

    private var data = listOf<List<RegistrationDataItem>>()

    inner class RecyclerViewHolder(private val binding: RegistrationUnitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val adapter = RegistrationInputFieldAdapter()
            adapter.submitList(data[adapterPosition])
            binding.rvRegistrationInputField.adapter = adapter
        }
    }

    fun setRegistrationUnitData(data: List<List<RegistrationDataItem>>) {
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RegistrationUnitBinding.inflate(layoutInflater, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}