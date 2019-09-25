package app.nikhil.tasker.ui.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

  abstract fun getViewModelClass(): Class<VM>

  abstract fun getLayoutId(): Int

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  lateinit var viewModel: VM
  lateinit var binding: B

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUI()
  }

  private fun initUI() {
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    binding = DataBindingUtil.setContentView(this, getLayoutId())
  }
}