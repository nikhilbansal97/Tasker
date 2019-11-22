package app.nikhil.tasker.injection.component

import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.module.ActivityBindingModule
import app.nikhil.tasker.injection.module.AppModule
import app.nikhil.tasker.injection.module.RepositoryModule
import app.nikhil.tasker.injection.module.ViewModelBindingModule
import app.nikhil.tasker.ui.daggertest.DaggerTestActivity
import app.nikhil.tasker.ui.daggertest.DaggerTestViewModel
import app.nikhil.tasker.work.DatabaseSyncWorker
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    ViewModelBindingModule::class,
    RepositoryModule::class
  ]
)
interface AppComponent : AndroidInjector<TaskerApplication> {

  fun inject(target: DatabaseSyncWorker)
  fun inject(target: DaggerTestViewModel)
  fun inject(target: DaggerTestActivity)

  @Component.Factory
  abstract class Factory : AndroidInjector.Factory<TaskerApplication>
}