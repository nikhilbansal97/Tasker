package app.nikhil.tasker.ui.tasklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.nikhil.tasker.R
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.databinding.LayoutTaskListItemBinding
import app.nikhil.tasker.ui.tasklist.TaskListAdapter.TaskViewHolder

class TaskListAdapter(
  private val tasksList: ArrayList<Task>,
  private val listener: TaskAdapterListener
) : RecyclerView.Adapter<TaskViewHolder>() {

  override fun getItemCount(): Int = tasksList.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder =
    TaskViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.layout_task_list_item, parent, false
      )
    )

  override fun onBindViewHolder(taskHolder: TaskViewHolder, position: Int) {
    taskHolder.bind(tasksList[position])
  }

  fun updateTasksList(list: List<Task>) {
    tasksList.clear()
    tasksList.addAll(list)
    notifyDataSetChanged()
  }

  inner class TaskViewHolder(
    private val itemBinding: LayoutTaskListItemBinding
  ) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(task: Task) {
      itemBinding.tvTaskTitle.text = task.title
      itemBinding.root.setOnClickListener { listener.taskClicked(task) }
    }
  }

  interface TaskAdapterListener {
    fun taskClicked(task: Task)
  }
}