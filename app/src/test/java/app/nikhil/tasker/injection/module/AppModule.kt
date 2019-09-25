package app.nikhil.tasker.injection.module

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class AppModule {

  @Provides
  @IntoMap
  @StringKey("foo")
  fun provideStringFoo(): Int = 1001
}