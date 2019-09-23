package app.nikhil.tasker.ui.tasklist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import app.nikhil.tasker.R.layout
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class TaskListActivity : DaggerAppCompatActivity() {

  @Inject lateinit var appContext: Context
  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_task_list)
  }
}
