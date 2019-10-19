package util

import model.Book


class BookOperations {

    fun IsIsbnExistInList(books : List<Book>, Isbn: Long) : Boolean    {
        var r: Book? = books.find { s -> s.ISBN == Isbn }
        return r != null
    }

    fun CreateUpdateBook(books : ArrayList<Book>, book: Book) : ArrayList<Book>{

        if (!IsIsbnExistInList(books, book.ISBN))
        {
            books.add(book)
        }
        else
        {
            var newBookList : ArrayList<Book>
            var r: Book = books.find { s -> s.ISBN == book.ISBN }!!
            var newQty = ((book.Qty.toInt()).plus(r.Qty.toInt()))
            r.Qty = newQty
        }
        return books
    }
}