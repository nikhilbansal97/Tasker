package app.nikhil.tasker.ui.addtask

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import app.nikhil.tasker.R
import app.nikhil.tasker.R.string
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.databinding.ActivityAddTaskBinding
import app.nikhil.tasker.ui.base.BaseActivity
import app.nikhil.tasker.utils.KEY_TASK_OBJECT

class AddTaskActivity : BaseActivity<ActivityAddTaskBinding, AddTaskViewModel>() {

  override fun getViewModelClass(): Class<AddTaskViewModel> = AddTaskViewModel::class.java

  override fun getLayoutId(): Int = R.layout.activity_add_task

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUi()
    addObservers()
  }

  private fun addObservers() {
    viewModel.saveStatusLiveData.observe(this, Observer {
      it?.let { isSaved ->
        when {
          isSaved -> finish()
          else -> Toast.makeText(this, "Unable to Save", Toast.LENGTH_SHORT).show()
        }
      }
    })
  }

  private fun initUi() {
    val task = intent?.extras?.getParcelable<Task>(KEY_TASK_OBJECT)
    if (task == null) {
      binding.btnSaveTask.setOnClickListener { viewModel.saveTask() }
    } else {
      binding.btnSaveTask.apply {
        text = context.getString(string.update)
        setOnClickListener { viewModel.updateTask(task) }
      }
      binding.btnDelete.setOnClickListener { showDeleteConfirmationDialog(task) }
      binding.btnDelete.visibility = View.VISIBLE
      viewModel.taskTitle = task.title
      viewModel.taskDescription = task.description
    }
    binding.btnClose.setOnClickListener { finish() }
  }

  private fun showDeleteConfirmationDialog(task: Task) {
    AlertDialog.Builder(this)
      .setTitle(getString(string.confirm))
      .setMessage(getString(string.delete_confirm_message))
      .setPositiveButton(getString(string.yes)) { _, _ -> viewModel.deleteTask(task) }
      .setNegativeButton(getString(string.no)) { dialog, _ -> dialog.dismiss() }
      .show()
  }
}