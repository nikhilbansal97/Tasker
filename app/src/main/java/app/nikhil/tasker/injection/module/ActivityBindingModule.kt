package app.nikhil.tasker.injection.module

import app.nikhil.tasker.ui.addtask.AddTaskActivity
import app.nikhil.tasker.ui.tasklist.TaskListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

  @ContributesAndroidInjector
  abstract fun bindTaskListActivity(): TaskListActivity

  @ContributesAndroidInjector
  abstract fun bindAddTaskActivity(): AddTaskActivity
}