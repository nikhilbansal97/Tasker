package app.nikhil.tasker.injection.component

import app.nikhil.tasker.injection.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface TestAppComponent {
  fun intsByString(): Map<String, Int>

  @Component.Factory
  interface Factory {
    fun create(): TestAppComponent
  }
}