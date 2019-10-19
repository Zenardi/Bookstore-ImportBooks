package util

import model.Book


class BookOperations {

    fun IsIsbnExistInList(books : List<Book>, Isbn: String) : Boolean    {

        var r: Book? = books.find { s -> s.ISBN == Isbn }
        if (r != null)
            return true;
        else
            return false;
    }

    fun CreateUpdateBook(books : ArrayList<Book>, book: Book) : ArrayList<Book>{

        if (!IsIsbnExistInList(books, book.ISBN))
        {
            books.add(book);
        }
        else
        {
            var newBookList : ArrayList<Book>
            var r: Book = books.find { s -> s.ISBN == book.ISBN }!!

            var newQty = ((book.Qty?.toInt())?.plus(r.Qty?.toInt()!!))
            //book.Qty = newQty
            r.Qty = newQty

            //var a = books.remove(book)
            //books.add(r)
        }
        return books
    }
}