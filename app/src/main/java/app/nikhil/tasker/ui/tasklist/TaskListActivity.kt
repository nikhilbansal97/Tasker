package app.nikhil.tasker.ui.tasklist

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import app.nikhil.tasker.R
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.databinding.ActivityTaskListBinding
import app.nikhil.tasker.ui.addtask.AddTaskActivity
import app.nikhil.tasker.ui.base.BaseActivity
import app.nikhil.tasker.ui.tasklist.TaskListAdapter.TaskAdapterListener
import app.nikhil.tasker.utils.KEY_TASK_OBJECT

class TaskListActivity : BaseActivity<ActivityTaskListBinding, TaskListViewModel>() {

  override fun getViewModelClass(): Class<TaskListViewModel> = TaskListViewModel::class.java

  override fun getLayoutId(): Int = R.layout.activity_task_list

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUi()
    addObservers()
  }

  private fun addObservers() {
    viewModel.tasksListLiveData.observe(this, Observer {
      it?.let { tasksList ->
        (binding.rvTasksList.adapter as TaskListAdapter).updateTasksList(tasksList)
      }
    })
  }

  private fun navigateToAddTaskActivity(task: Task? = null) {
    val intent = Intent(this, AddTaskActivity::class.java)
    if (task != null) {
      val data = Bundle().apply {
        putParcelable(KEY_TASK_OBJECT, task)
      }
      intent.putExtras(data)
      startActivity(intent, data)
    } else {
      startActivity(intent)
    }
  }

  private fun initUi() {
    binding.rvTasksList.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = TaskListAdapter(arrayListOf(), object : TaskAdapterListener {
        override fun taskClicked(task: Task) {
          navigateToAddTaskActivity(task)
        }
      })
    }
    binding.fabAddTask.setOnClickListener { navigateToAddTaskActivity() }
  }
}
