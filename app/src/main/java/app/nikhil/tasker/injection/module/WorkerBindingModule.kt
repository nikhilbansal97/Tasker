package app.nikhil.tasker.injection.module

import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import app.nikhil.tasker.injection.multibinding.WorkerKey
import app.nikhil.tasker.work.DatabaseSyncWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WorkerBindingModule {

  @Binds
  @IntoMap
  @WorkerKey(DatabaseSyncWorker::class)
  abstract fun bindDatabaseSyncWorker(databaseSyncWorker: DatabaseSyncWorker): CoroutineWorker
}