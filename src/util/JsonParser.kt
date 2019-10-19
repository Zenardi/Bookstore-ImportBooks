package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import model.Book
import java.io.File

class JsonParser{

    fun readJsonFileKotlin(jsonFile :String,books: ArrayList<Book>) : ArrayList<Book> {
        var content = File(jsonFile).readText()

        content = content.replace("Qty.", "Qty").replace("Age Range", "AgeRange")
        val mapper = ObjectMapper().registerModule(KotlinModule())

        var result = mapper.readValue<List<Book>>(content)

        for(book in result){
            books.add(book)
        }

        return books
    }

}