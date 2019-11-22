package app.nikhil.tasker.injection.module

import android.content.Context
import app.nikhil.tasker.TaskerApplication
import app.nikhil.tasker.injection.qualifier.ApplicationContext
import app.nikhil.tasker.ui.daggertest.DaggerTestViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {

  @Provides
  @ApplicationContext
  fun provideContext(taskerApplication: TaskerApplication): Context = taskerApplication

  @Provides
  @ApplicationContext
  fun provideDaggerTestViewModel(): DaggerTestViewModel = DaggerTestViewModel()
}