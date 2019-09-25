package app.nikhil.tasker.database

import androidx.lifecycle.LiveData
import app.nikhil.tasker.database.dao.TaskDao
import app.nikhil.tasker.database.entities.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

  suspend fun saveTask(task: Task): Int {
    return withContext(Dispatchers.IO) {
      taskDao.saveTask(task).toInt()
    }
  }

  fun loadTasks(): LiveData<List<Task>> {
    return taskDao.getTasks()
  }

  suspend fun updateTask(task: Task): Int {
    return withContext(Dispatchers.IO) {
      taskDao.updateTask(task)
    }
  }

  suspend fun deleteTask(task: Task) {
    withContext(Dispatchers.IO) { taskDao.deleteTask(task) }
  }
}