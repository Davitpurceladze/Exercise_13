package com.example.exercise_13.registration

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_13.databinding.RegistrationChooserFieldBinding
import com.example.exercise_13.databinding.RegistrationInputFieldBinding

class RegistrationInputFieldAdapter :
    ListAdapter<RegistrationDataItem, RecyclerView.ViewHolder>(
        DiffUtilCallback()
    ) {

    private class DiffUtilCallback : DiffUtil.ItemCallback<RegistrationDataItem>() {
        override fun areItemsTheSame(
            oldItem: RegistrationDataItem,
            newItem: RegistrationDataItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RegistrationDataItem,
            newItem: RegistrationDataItem
        ): Boolean {
            return oldItem == newItem
        }
    }


    inner class RecyclerInputViewHolder(private val binding: RegistrationInputFieldBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                etInputField.hint = item.hint
                if (item.keyboard == KeyboardType.TEXT) {
                    etInputField.inputType = InputType.TYPE_CLASS_TEXT
                } else if (item.keyboard == KeyboardType.NUMBER) {
                    etInputField.inputType = InputType.TYPE_CLASS_NUMBER
                }

            }
        }
    }

    inner class RecyclerChooserViewHolder(private val binding: RegistrationChooserFieldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = currentList[adapterPosition]
            with(binding){
                tvChooser.hint = item.hint


            }
//            set lambda function to click listeners
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == INPUT) {
            val binding = RegistrationInputFieldBinding.inflate(layoutInflater, parent, false)
            RecyclerInputViewHolder(binding)
        } else {
            val binding = RegistrationChooserFieldBinding.inflate(layoutInflater, parent, false)
            RecyclerChooserViewHolder(binding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RecyclerInputViewHolder) {
            holder.bind()
        } else if (holder is RecyclerChooserViewHolder) {
            holder.bind()

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].fieldType == FieldType.INPUT) {
            INPUT
        } else CHOOSER
    }

    companion object {
        const val INPUT = 1
        const val CHOOSER = 2
    }

}