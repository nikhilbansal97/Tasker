package app.nikhil.tasker.ui.base

import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.nikhil.tasker.BR
import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.ui.addtask.AddTaskActivity
import app.nikhil.tasker.ui.tasklist.TaskListActivity
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

  abstract fun getViewModelClass(): Class<VM>

  abstract fun getLayoutId(): Int

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  lateinit var viewModel: VM
  lateinit var binding: B

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUI()
    requestPermissionsIfNotAvailable()
  }

  fun <T : Any> initDagger(instance: T) {
    when (instance) {
      is TaskListActivity -> (application as TaskerApplication).getAppComponent().inject(instance)
      is AddTaskActivity -> (application as TaskerApplication).getAppComponent().inject(instance)
    }
  }

  private fun requestPermissionsIfNotAvailable() {
    if (ActivityCompat.checkSelfPermission(
        this,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
      ) != PERMISSION_GRANTED
    ) {
      ActivityCompat.requestPermissions(
        this,
        arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
        1001
      )
    }
  }

  private fun initUI() {
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    binding = DataBindingUtil.setContentView(this, getLayoutId())
    binding.setVariable(BR.viewModel, viewModel)
  }
}