package app.nikhil.tasker.ui.daggertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DaggerTestActivity : AppCompatActivity() {

  @Inject
  lateinit var viewModel: DaggerTestViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    Timber.d(viewModel.isInjectionSuccessful().toString())
  }
}