package util

import model.Book
import java.io.File

class CsvParser {
     fun readCsvFileKotlin(csvFile: String) : ArrayList<Book> {
        var books = ArrayList<Book>()

        var reader = File(csvFile).readLines()

         var i : Int = 0
        for (line in reader) {

            if(i>0) {
                val mbrProperties = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())
                var book : Book = Book()
                //Title,Description,ISBN,Author,Genre,Pages,Age Range,Price,Qty.

                book.Title = mbrProperties[0]
                book.Description = mbrProperties[1]
                book.ISBN = mbrProperties[2]
                book.Author = mbrProperties[3]
                book.Genre  = mbrProperties[4]
                book.Pages = mbrProperties[5]
                book.AgeRange = mbrProperties[6]
                book.Price = mbrProperties[7]

                print(mbrProperties[8] + ", ")
                book.Qty = mbrProperties[8]

                if (book != null) {
                    books.add(book)
                }
            }

            i++

        }

        return books;
    }

}

