package app.nikhil.tasker.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.nikhil.tasker.injection.multibinding.ViewModelKey
import app.nikhil.tasker.ui.addtask.AddTaskViewModel
import app.nikhil.tasker.ui.tasklist.TaskListViewModel
import app.nikhil.tasker.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindingModule {

  @Binds
  @IntoMap
  @ViewModelKey(TaskListViewModel::class)
  abstract fun bindTaskListViewModel(taskListViewModel: TaskListViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(AddTaskViewModel::class)
  abstract fun bindAddTaskViewModel(addTaskViewModel: AddTaskViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}