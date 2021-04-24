package school.cactus.minimalroomprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var soup: String = ""
    var mainDish: String = ""
    var desert: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MenuDatabase.getInstance(applicationContext)
        val menuDao = db.menuDao()

        val uiScope = CoroutineScope(Dispatchers.IO + Job())
        menuDao.getAllMenus().observe(this@MainActivity) { menuList ->
            menuList.forEach {
                Log.e("MenuDb", it.toString())
            }
        }

        val foodGenerator = WeirdFoodGenerator()
        val generateButton: Button = findViewById(R.id.generateButton)
        val saveButton: Button = findViewById(R.id.saveButton)
        val foodText: TextView = findViewById(R.id.foodText)

        generateButton.setOnClickListener {
            soup = foodGenerator.generateSoup()
            mainDish = foodGenerator.generateMainDish()
            desert = foodGenerator.generateDesert()

            foodText.text = "Soup:\n$soup\n\nMain Dish:\n$mainDish\n\nDesert:\n$desert"
        }

        saveButton.setOnClickListener {
            uiScope.launch {
                val menuToSave = Menu(soup = soup, mainDish = mainDish, desert = desert)
                menuDao.insertMenu(menuToSave)
            }
        }
    }
}