package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import model.Book
import java.io.File

class JsonParser{

    fun readJsonFileKotlin(jsonFile :String, books: ArrayList<Book>) : ArrayList<Book> {
        var newBookList : ArrayList<Book> = ArrayList()
        var bookOp: BookOperations = BookOperations()
        var content = File(jsonFile).readText()

        content = content.replace("Qty.", "Qty").replace("Age Range", "AgeRange")
        val mapper = ObjectMapper().registerModule(KotlinModule())

        var result = mapper.readValue<List<Book>>(content)

        for(book in result){
//            var newIsbn : String = book.ISBN
//            if( book.ISBN[0] == '0')
//                newIsbn =  book.ISBN.substring(1).replace(" ", "")

           newBookList =  bookOp.CreateUpdateBook(books, book)
        }

        return newBookList
    }

}