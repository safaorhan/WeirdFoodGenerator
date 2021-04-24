package school.cactus.minimalroomprep

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu")
data class Menu(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "soup")
    val soup: String,

    @ColumnInfo(name = "main_dish")
    val mainDish: String,

    @ColumnInfo(name = "desert")
    val desert: String
)