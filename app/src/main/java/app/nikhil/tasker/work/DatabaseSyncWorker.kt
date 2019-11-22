package app.nikhil.tasker.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import app.nikhil.tasker.database.dao.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class DatabaseSyncWorker(
  context: Context,
  params: WorkerParameters
) : CoroutineWorker(context, params) {

  @Inject
  lateinit var taskDao: TaskDao

  override suspend fun doWork(): Result {
    return withContext(Dispatchers.IO) {
      Timber.d("Fetching the entries from database")
      val tasks = taskDao.getTasks()
      Timber.d(tasks.toString())
      Timber.d("Fetching completed.")
      Result.success()
    }
  }
}