package come.geekbrains.vitekm.weatherlessonan.lesson3

import android.util.Log

class Lesson3 {

    fun test(){
        val people: MutableList<Person> = mutableListOf(Person("name1", 20),Person("name2", 25),
            Person("name3", 30))

        people[1]
        people.get(0)
        people[0].age
        people.size
        people.add(Person("name5", 27))

        write(32)
        write(24.6)
        write(14)
        write("Oko")

        writeAll(13.4)
        writeAll("error")
        writeAll(24)
    }

    fun <TT> writeAll(i: TT){               //дженерики TT
        Log.d("", " it's $i")
    }

    fun write(i: Int){
        Log.d("", " it's $i")
    }

    fun write(i: Double){
        Log.d("", " it's $i")
    }

    fun write(i: Byte){
        Log.d("", " it's $i")
    }

    fun write(i: String){
        Log.d("", " it's $i")
    }

  data class Person(val name: String, var age: Int = 40) {

    }


}