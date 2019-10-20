package main.java.util

import main.java.model.Book


class BookOperations {

    private fun isIsbnExistInList(books : List<Book>, Isbn: Long) : Boolean    {
        var r: Book? = books.find { s -> s.ISBN == Isbn }
        return r != null
    }

    fun createUpdateBook(books : ArrayList<Book>, book: Book) : ArrayList<Book>{

        if (!isIsbnExistInList(books, book.ISBN))
        {
            books.add(book)
        }
        else
        {
            var r: Book = books.find { s -> s.ISBN == book.ISBN }!!
            var newQty = ((book.Qty.toInt()).plus(r.Qty.toInt()))
            r.Qty = newQty
        }
        return books
    }
}