package app.nikhil.tasker.tests

import androidx.test.runner.AndroidJUnit4
import app.nikhil.tasker.injection.AndroidTestComponent
import app.nikhil.tasker.injection.DaggerAndroidTestComponent
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BaseTest {

  lateinit var androidTestComponent: AndroidTestComponent

  @Test
  fun testMap() {
    androidTestComponent = DaggerAndroidTestComponent.create()
    val map = androidTestComponent.intsByString()
    Truth.assertThat(map).isNotNull()
  }
}