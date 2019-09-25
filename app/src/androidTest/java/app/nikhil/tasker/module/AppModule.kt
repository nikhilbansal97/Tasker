package app.nikhil.tasker.module

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class AppModule {

  @Provides
  @IntoMap
  @StringKey("foo")
  fun provideFooValue(): Int = 1009
}