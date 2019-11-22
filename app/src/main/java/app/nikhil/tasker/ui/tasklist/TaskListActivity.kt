package app.nikhil.tasker.ui.tasklist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import androidx.work.Configuration
import androidx.work.Constraints
import androidx.work.NetworkType.CONNECTED
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import app.nikhil.tasker.R
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.databinding.ActivityTaskListBinding
import app.nikhil.tasker.ui.addtask.AddTaskActivity
import app.nikhil.tasker.ui.base.BaseActivity
import app.nikhil.tasker.ui.tasklist.TaskListAdapter.TaskAdapterListener
import app.nikhil.tasker.utils.KEY_TASK_OBJECT
import app.nikhil.tasker.work.DatabaseSyncWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import java.time.Duration
import java.time.temporal.TemporalAmount
import javax.inject.Inject

class TaskListActivity : BaseActivity<ActivityTaskListBinding, TaskListViewModel>() {

  override fun getViewModelClass(): Class<TaskListViewModel> = TaskListViewModel::class.java

  override fun getLayoutId(): Int = R.layout.activity_task_list

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUi()
    addObservers()
    //    initWorkManager()
  }

  @SuppressLint("NewApi")
  private fun initWorkManager() {
    // Create the work request.
    val workRequest =
      PeriodicWorkRequest.Builder(DatabaseSyncWorker::class.java, Duration.ofMinutes(1))
        .setConstraints(Constraints.Builder().setRequiredNetworkType(CONNECTED).build())
        .build()
    // Enqueue the work.
    WorkManager.getInstance(this).enqueue(workRequest)
  }

  private fun addObservers() {
    viewModel.tasksListLiveData.observe(this, Observer {
      it?.let { tasksList -> updateUI(tasksList) }
    })
  }

  private fun updateUI(tasksList: List<Task>) {
    if (tasksList.isEmpty()) {
      binding.rvTasksList.visibility = View.GONE
      binding.noTasks.visibility = View.VISIBLE
    } else {
      binding.rvTasksList.visibility = View.VISIBLE
      binding.noTasks.visibility = View.GONE
      (binding.rvTasksList.adapter as TaskListAdapter).updateTasksList(tasksList)
    }
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
