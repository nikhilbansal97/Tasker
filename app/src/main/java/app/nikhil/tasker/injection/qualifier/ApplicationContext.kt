package app.nikhil.tasker.injection.qualifier

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.annotation.AnnotationTarget.FUNCTION

@Target(FIELD, FUNCTION)
@Retention(RUNTIME)
annotation class ApplicationContext