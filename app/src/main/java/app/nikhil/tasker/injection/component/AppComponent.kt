package app.nikhil.tasker.injection.component

import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.module.AppModule
import app.nikhil.tasker.injection.module.RepositoryModule
import app.nikhil.tasker.injection.module.ViewModelBindingModule
import app.nikhil.tasker.ui.addtask.AddTaskActivity
import app.nikhil.tasker.ui.tasklist.TaskListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AppModule::class,
    RepositoryModule::class,
    ViewModelBindingModule::class
  ]
)
interface AppComponent {

  fun inject(target: TaskListActivity)
  fun inject(target: AddTaskActivity)

  @Component.Builder
  interface Builder {
    fun application(@BindsInstance taskerApplication: TaskerApplication): Builder
    fun build(): AppComponent
  }
}