package come.geekbrains.vitekm.weatherlessonan.lesson3

class Lesson3 {

    fun test(){
        val people: MutableList<Person> = mutableListOf(Person("name1", 20),Person("name2", 25),
            Person("name3", 30))

        people[1]
        people.get(0)
        people[0].age
        people.size
        people.add(Person("name5", 27))
    }

  data class Person(val name: String, var age: Int = 40) {

    }


}