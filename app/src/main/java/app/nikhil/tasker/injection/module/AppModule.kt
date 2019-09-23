package app.nikhil.tasker.injection.module

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton
  @ApplicationContext
  fun provideContext(taskerApplication: TaskerApplication): Context = taskerApplication
}