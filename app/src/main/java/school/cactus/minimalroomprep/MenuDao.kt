package school.cactus.minimalroomprep

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuDao {
    @Insert
    fun insertMenu(menu: Menu)

    @Update
    fun updateMenu(menu: Menu)

    @Query("SELECT * FROM menu WHERE soup LIKE :query OR main_dish LIKE :query OR desert LIKE :query")
    fun searchMenu(query: String): LiveData<List<Menu>>

    @Query("SELECT * FROM menu")
    fun getAllMenus(): LiveData<List<Menu>>
}