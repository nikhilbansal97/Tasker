package app.nikhil.tasker.ui.tasklist

import android.content.Context
import android.os.Bundle
import app.nikhil.tasker.R
import app.nikhil.tasker.databinding.ActivityTaskListBinding
import app.nikhil.tasker.ui.base.BaseActivity
import javax.inject.Inject

class TaskListActivity : BaseActivity<ActivityTaskListBinding, TaskListViewModel>() {

  override fun getViewModelClass(): Class<TaskListViewModel> = TaskListViewModel::class.java

  override fun getLayoutId(): Int = R.layout.activity_task_list

  @Inject
  lateinit var appContext: Context

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }
}
