package com.bookstore.importbooks

import com.fasterxml.jackson.databind.JsonNode
import main.java.model.Book
import main.java.util.CsvParser
import main.java.util.JsonParser
import java.io.File
import com.google.gson.GsonBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.dataformat.csv.CsvMapper








fun main(args: Array<String>) {
    //var basePath = args[0].toString()
    var basePath = "C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\main\\kotlin\\com\\bookstore\\TestFiles"
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

    //TODO order
    //books = books.toList().

    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonBookList: String = gson.toJson(books)
    File(basePath + "\\books-consolidated.json").writeText(jsonBookList)

    val jsonTree = ObjectMapper().readTree(File(basePath + "\\books-consolidated.json"))
    val csvSchemaBuilder = CsvSchema.builder()
    val firstObject = jsonTree.elements().next()
    firstObject.fieldNames().forEachRemaining { fieldName -> csvSchemaBuilder.addColumn(fieldName) }
    val csvSchema = csvSchemaBuilder.build().withHeader()

    val csvMapper = CsvMapper()
    csvMapper.writerFor(JsonNode::class.java)
        .with(csvSchema)
        .writeValue(File(basePath + "\\books-consolidated.csv"), jsonTree)
}



