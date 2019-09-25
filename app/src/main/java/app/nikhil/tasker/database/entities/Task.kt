package app.nikhil.tasker.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Task(
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0,
  val title: String,
  val description: String,
  val status: Int
): Parcelable