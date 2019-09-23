package app.nikhil.tasker.injection.component

import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.module.ActivityBindingModule
import app.nikhil.tasker.injection.module.AppModule
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class
  ]
)
interface AppComponent : AndroidInjector<TaskerApplication> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: TaskerApplication): AppComponent
  }
}