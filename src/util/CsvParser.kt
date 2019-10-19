package util

import model.Book
import java.io.File

class CsvParser {
     fun readCsvFileKotlin(csvFilePath: String, books: ArrayList<Book>) : ArrayList<Book> {
         var newBookList : ArrayList<Book> = ArrayList()
         var bookOp: BookOperations = BookOperations()
         var reader = File(csvFilePath).readLines()

         var i : Int = 0
        for (line in reader) {

            if(i>0) {
                val mbrProperties = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())
                var book : Book = Book()
                //Title,Description,ISBN,Author,Genre,Pages,Age Range,Price,Qty.
                var newIsbn : String = mbrProperties[2]
                if( mbrProperties[2][0] == '0')
                    newIsbn =  mbrProperties[2].substring(1)

                book.Title = mbrProperties[0]
                book.Description = mbrProperties[1]
                book.ISBN = newIsbn
                book.Author = mbrProperties[3]
                book.Genre  = mbrProperties[4]
                book.Pages = mbrProperties[5]
                book.AgeRange = mbrProperties[6]
                book.Price = mbrProperties[7]
                book.Qty = mbrProperties[8].replace(" ", "").toInt()

                newBookList = bookOp.CreateUpdateBook(books, book)
            }

            i++

        }

        return newBookList;
    }

    fun readCsvFileKotlinContent(fileContent: String, books: ArrayList<Book>): ArrayList<Book> {
        var newBookList : ArrayList<Book> = ArrayList()
        var bookOp: BookOperations = BookOperations()
        var reader = fileContent.reader()

        //var reader = File(fileContent).readLines()

        var i : Int = 0
        for (line in reader.readLines()) {

            if(i>0) {
                val mbrProperties = line.split(",")
                var book : Book = Book()
                //Title,Description,ISBN,Author,Genre,Pages,Age Range,Price,Qty.
                var newIsbn : String = mbrProperties[2]
                if( mbrProperties[2][0] == '0')
                    newIsbn =  mbrProperties[2].substring(1)


                book.Title = mbrProperties[0]
                book.Description = mbrProperties[1]
                book.ISBN = newIsbn
                book.Author = mbrProperties[3]
                book.Genre  = mbrProperties[4]
                book.Pages = mbrProperties[5]
                book.AgeRange = mbrProperties[6]
                book.Price = mbrProperties[7]
                book.Qty = mbrProperties[8].replace(" ", "").toInt()

                newBookList = bookOp.CreateUpdateBook(books, book)
            }

            i++

        }

        return newBookList;
    }

}

