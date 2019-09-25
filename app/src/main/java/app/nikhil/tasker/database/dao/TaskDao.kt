package app.nikhil.tasker.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.nikhil.tasker.database.entities.Task

@Dao
interface TaskDao {

  @Insert
  suspend fun saveTask(task: Task): Long

  @Query("SELECT * from task")
  fun getTasks(): LiveData<List<Task>>

  @Update
  suspend fun updateTask(task: Task): Int

  @Delete
  fun deleteTask(task: Task)
}