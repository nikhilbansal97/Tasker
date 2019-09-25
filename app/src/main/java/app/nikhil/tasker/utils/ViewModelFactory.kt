package app.nikhil.tasker.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(
  private val map: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return map[modelClass]!!.get() as T
  }
}