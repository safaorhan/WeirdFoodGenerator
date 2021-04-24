package school.cactus.minimalroomprep

class WeirdFoodGenerator {
    private val fruitsAndVeggies = listOf(
        "apple",
        "orange",
        "banana",
        "strawberry",
        "plum",
        "grape",
        "peach",
        "apricot",
        "blueberry",
        "mandarin",
        "pear",
        "pomelo",
        "lemon",
        "ananas",
        "mango",
        "jackfruit",
        "durian",
        "honeymelon",
        "watermelon",
        "carrot",
        "eggplant",
        "pepper",
        "tomato",
        "cabbage",
        "pumpkin",
        "onion",
        "garlic",
        "zucchini",
        "chilli",
        "kale",
        "spinach",
        "potato",
        "hazelnut",
        "walnut",
        "peanut",
        "cashew",
        "curry"
    )

    private val proteins = listOf(
        "meat",
        "mutton",
        "chicken",
        "beef",
        "tuna",
        "sardines",
        "salmon",
        "egg",
        "milk",
        "cheddar",
        "mozzarella",
        "gouda",
    )

    private val cookingMethods = listOf(
        "slow-cooked",
        "fried",
        "baked",
        "sauted",
        "refrigerated",
        "frozen",
        "grilled",
        "roasted",
        "toasted"
    )

    private val shapes = listOf(
        "spirals",
        "chips",
        "balls",
        "sticks",
        "slices",
        "fries",
        "soup",
        "dinner",
        "snacks",
        "stew",
        "nuggets",
    )

    private val pastries = listOf(
        "muffins",
        "cake",
        "slices",
        "buns",
        "rolls",
        "pie"
    )

    private val soups = listOf(
        "[f] soup",
        "[p] soup",
        "[p] and [f] soup",
        "[c] [f] soup"
    )

    private val mainDishes = listOf(
        "[c] [f] [s]",
        "[p] [s]",
        "[p] [s] with [f] sauce",
        "[c] [p] with [f] [s]",
        "[p] [f] [s]",
        "[c] [p]",
        "[p] marinated in [f]",
        "[f] [s] with [p] sauce",
        "[f] [s]",
        "[c] [p] and [f] [s]"
    )

    private val deserts = listOf(
        "[f] and chocolate [pa]",
        "[f] [pa]",
        "sweet [f] [pa]",
        "[f] in syrup",
        "[f] pops"
    )

    private fun List<String>.generate() = random()
        .replace("[c]", cookingMethods.random())
        .replace("[f]", fruitsAndVeggies.random())
        .replace("[p]", proteins.random())
        .replace("[pa]", pastries.random())
        .replace("[s]", shapes.random())
        .capitalize()

    fun generateSoup() = soups.generate()

    fun generateMainDish() = mainDishes.generate()

    fun generateDesert() = deserts.generate()
}