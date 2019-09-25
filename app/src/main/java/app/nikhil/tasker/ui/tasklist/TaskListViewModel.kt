package app.nikhil.tasker.ui.tasklist

import androidx.lifecycle.LiveData
import app.nikhil.tasker.database.TaskRepository
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.ui.base.BaseViewModel
import javax.inject.Inject

class TaskListViewModel @Inject constructor(
  private val taskRepository: TaskRepository
) : BaseViewModel() {

  val tasksListLiveData: LiveData<List<Task>> = taskRepository.loadTasks()
}