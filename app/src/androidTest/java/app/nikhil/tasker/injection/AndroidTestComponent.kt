package app.nikhil.tasker.injection

import app.nikhil.tasker.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AndroidTestComponent {
  fun intsByString(): Map<String, Int>
}