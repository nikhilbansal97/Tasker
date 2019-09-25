package app.nikhil.tasker.database.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.nikhil.tasker.database.dao.TaskDao
import app.nikhil.tasker.database.entities.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

  companion object {
    private var INSTANCE: TaskDatabase? = null
    fun getInstance(context: Context): TaskDatabase {
      return INSTANCE ?: run {
         INSTANCE = Room.databaseBuilder(
          context,
          TaskDatabase::class.java,
          "TaskDatabase"
        ).build()
        return INSTANCE!!
      }
    }
  }

  abstract fun getTaskDao(): TaskDao
}