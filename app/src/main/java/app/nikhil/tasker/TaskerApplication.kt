package app.nikhil.tasker

import android.app.Application
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView
import app.nikhil.tasker.injection.component.AppComponent
import app.nikhil.tasker.injection.component.DaggerAppComponent

class TaskerApplication : Application() {

  private lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    initDagger()
  }

  private fun initDagger() {
    appComponent = DaggerAppComponent.builder()
      .application(this)
      .build()
  }

  fun getAppComponent(): AppComponent = appComponent
}