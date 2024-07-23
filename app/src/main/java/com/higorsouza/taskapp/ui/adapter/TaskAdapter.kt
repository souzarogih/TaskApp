package com.higorsouza.taskapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.higorsouza.taskapp.R
import com.higorsouza.taskapp.data.model.Status
import com.higorsouza.taskapp.data.model.Task
import com.higorsouza.taskapp.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context,
    private val taskList: List<Task>,
    private val taskSelected: (Task, Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    companion object {
        val SELECT_BACK: Int = 1
        val SELECT_REMOVE: Int = 2
        val SELECT_EDIT: Int = 3
        val SELECT_DETAILS: Int = 4
        val SELECT_NEXT: Int = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.textDescription.text = task.description
        setIndicators(task, holder)

        holder.binding.btnDelete.setOnClickListener {taskSelected(task, SELECT_REMOVE)}
        holder.binding.btnEdit.setOnClickListener {taskSelected(task, SELECT_EDIT)}
        holder.binding.btnDetails.setOnClickListener {taskSelected(task, SELECT_DETAILS)}
    }

    private fun setIndicators(task: Task, holder: MyViewHolder) {
        when (task.status.name) {
            Status.TODO.toString() -> {
                holder.binding.btnBack.isVisible = false

                holder.binding.btnNext.setOnClickListener {taskSelected(task, SELECT_NEXT)}
            }

            Status.DOING.toString() -> {
                holder.binding.btnBack.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_todo
                    )
                )

                holder.binding.btnNext.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_done
                    )
                )

                holder.binding.btnBack.setOnClickListener {taskSelected(task, SELECT_BACK)}
                holder.binding.btnNext.setOnClickListener {taskSelected(task, SELECT_NEXT)}
            }

            Status.DONE.toString() -> {
                holder.binding.btnNext.isVisible = false

                holder.binding.btnBack.setOnClickListener {taskSelected(task, SELECT_BACK)}

            }
        }
    }

    inner class MyViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}