package com.bookstore.importbooks

import main.java.model.Book
import main.java.util.CsvParser
import main.java.util.JsonParser
import java.io.File
import com.google.gson.GsonBuilder


fun main(args: Array<String>) {
    var basePath = args[0].toString()
    //var basePath = "C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\"
    val csvParser = CsvParser()
    val jsonParser = JsonParser()
    var books = ArrayList<Book>()

    File(basePath).walkTopDown().forEach {
        if(it.extension.toLowerCase() == "json") {
            books = jsonParser.readJsonFileKotlin(it.absolutePath, books)
        }
        else if(it.extension.toLowerCase() == "txt"){
            var content = File(it.absolutePath).readText()
            //remove comma from description and replace tab with comma
            var result = content.replace(",","").replace("\t", ", ")
            books = csvParser.readCsvFileKotlinContent(result, books)
        }
        else if(it.extension.toLowerCase() == "csv"){
            books = csvParser.readCsvFileKotlin(it.absolutePath, books)
        }
    }

    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonBookList: String = gson.toJson(books)
    File(basePath + "\\books-consolidated.json").writeText(jsonBookList)
}



