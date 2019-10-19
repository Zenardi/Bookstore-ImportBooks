package util

import com.beust.klaxon.Klaxon
import model.Book
import java.io.File

class JsonParser{

    fun readJsonFileKotlin(jsonFile :String) : ArrayList<Book>{
        var books = ArrayList<Book>()

        var content = File(jsonFile).readText()
        print(content)
        val result = Klaxon().parse<ArrayList<Book>>(content)

        return books
    }

}