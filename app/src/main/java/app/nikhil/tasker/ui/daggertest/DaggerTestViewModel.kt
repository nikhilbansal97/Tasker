package app.nikhil.tasker.ui.daggertest

import androidx.lifecycle.ViewModel
import app.nikhil.tasker.database.TaskRepository
import javax.inject.Inject

class DaggerTestViewModel : ViewModel() {

  @Inject
  lateinit var repository: TaskRepository

  fun isInjectionSuccessful() = ::repository.isInitialized
}