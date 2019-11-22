package app.nikhil.tasker.injection.multibinding

import androidx.work.CoroutineWorker
import androidx.work.Worker
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class WorkerKey(val value: KClass<out CoroutineWorker>)