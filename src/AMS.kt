import java.util.*

fun main(args: Array<String>) {
    println("Good ${if(args[0].toInt() < 12) "morning" else "night"}, Kotlin")

    dayOfWeek()

    var fortune: String
    var i = 1
    while(i <= 10) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is: $fortune")
        if(fortune == "Take it easy and you will enjoy life!") break
        i++
    }

    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))

    print("How do you feel? ")
    println(whatShouldIDoToday(readLine()!!))
}

fun dayOfWeek() {
    println("What day is it today?")

    val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when(day) {
        1 -> println("Today is Sunday.")
        2 -> println("Today is Monday.")
        3 -> println("Today is Tuesday.")
        4 -> println("Today is Wednesday.")
        5 -> println("Today is Thursday.")
        6 -> println("Today is Friday.")
        7 -> println("Today is Saturday.")
    }
}

fun getBirthday() : Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(day: Int) : String {
    val fortunes: Array<String> = arrayOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and you will enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    return when(day) {
        in 1..7 -> fortunes[5]
        28, 31 -> fortunes[3]
        else -> fortunes[day%fortunes.size]
    }
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) : Boolean{
    return ((tankSize * if(hasDecorations) .8 else 1.0) - currentFish.sum()) >= fishSize
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String{
    return when {
        shouldBike(mood, weather) -> "Go for a bike ride."
        shouldStayInBed(mood, weather, temperature) -> "Stay in bed."
        shouldSwim(temperature) -> "Go swimming."
        else -> "Stay inside and read."
    }
}

fun shouldBike(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun shouldStayInBed(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun shouldSwim(temperature: Int) = temperature > 35