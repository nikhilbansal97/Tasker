package app.nikhil.tasker.utils

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Provider

class AppWorkerFactory(
  private val workerMap: Map<Class<out Worker>, @JvmSuppressWildcards Provider<Worker>>
) : WorkerFactory() {
  override fun createWorker(
    appContext: Context,
    workerClassName: String,
    workerParameters: WorkerParameters
  ): ListenableWorker? {
    return null
  }
}