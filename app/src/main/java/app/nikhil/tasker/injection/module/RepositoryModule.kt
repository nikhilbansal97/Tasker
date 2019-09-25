package app.nikhil.tasker.injection.module

import android.content.Context
import app.nikhil.tasker.database.dao.TaskDao
import app.nikhil.tasker.database.roomDb.TaskDatabase
import app.nikhil.tasker.injection.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

  @Provides
  @Singleton
  fun provideTaskerDao(@ApplicationContext context: Context): TaskDao {
    return TaskDatabase.getInstance(context).getTaskDao()
  }
}