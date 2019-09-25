package app.nikhil.tasker.ui.addtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import app.nikhil.tasker.database.TaskRepository
import app.nikhil.tasker.database.entities.Task
import app.nikhil.tasker.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class AddTaskViewModel @Inject constructor(
  private val taskRepository: TaskRepository
) : BaseViewModel() {

  /*
  * Variables for data binding
  */
  var taskTitle = ""
  var taskDescription = ""

  private val _saveStatusLiveData = MutableLiveData<Boolean>()
  val saveStatusLiveData: LiveData<Boolean>
    get() = _saveStatusLiveData

  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Timber.e(throwable)
  }

  /*
  * Save the task in database
  */
  fun saveTask() {
    viewModelScope.launch(exceptionHandler) {
      val id =
        taskRepository.saveTask(
          Task(
            title = taskTitle,
            description = taskDescription,
            status = 1
          )
        )
      _saveStatusLiveData.value = id != -1
    }
  }

  fun updateTask(task: Task) {
    viewModelScope.launch {
      val id: Int =
        taskRepository.updateTask(task.copy(title = taskTitle, description = taskDescription))
      _saveStatusLiveData.value = id != -1
    }
  }
}
