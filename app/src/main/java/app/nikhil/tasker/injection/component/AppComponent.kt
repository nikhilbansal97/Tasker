package app.nikhil.tasker.injection.component

import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.module.ActivityBindingModule
import app.nikhil.tasker.injection.module.AppModule
import app.nikhil.tasker.injection.module.RepositoryModule
import app.nikhil.tasker.injection.module.ViewModelBindingModule
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

  @Component.Factory
  abstract class Factory : AndroidInjector.Factory<TaskerApplication>
}