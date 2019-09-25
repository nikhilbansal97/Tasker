package app.nikhil.tasker.injection.multibinding

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/*
* MapKey for using map multi binding in dagger
*/
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)