package school.cactus.minimalroomprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodGenerator = WeirdFoodGenerator()
        val generateButton: Button = findViewById(R.id.generateButton)
        val foodText: TextView = findViewById(R.id.foodText)

        generateButton.setOnClickListener {
            val soup = foodGenerator.generateSoup()
            val mainDish = foodGenerator.generateMainDish()
            val desert = foodGenerator.generateDesert()

            foodText.text = "Soup:\n$soup\n\nMain Dish:\n$mainDish\n\nDesert:\n$desert"
        }
    }
}