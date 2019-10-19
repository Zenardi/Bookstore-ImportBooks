package util

import com.beust.klaxon.Klaxon
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import model.Book
import org.jetbrains.kotlin.com.google.gson.annotations.JsonAdapter
import java.io.File

class JsonParser{

    fun readJsonFileKotlin(jsonFile :String) : List<*> {
        var books = ArrayList<Book>()

        var content = File(jsonFile).readText()
        print(content)

        val mapper = ObjectMapper().registerModule(KotlinModule())
        return mapper.readValue(content, List::class.java)

    }

}