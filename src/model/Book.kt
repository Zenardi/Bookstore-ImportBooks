package model

public class Book {

   // var id: String? = null
    var Title: String? = null
    var Description: String? = null
    var ISBN: String? = null
    var Author: String? = null
    var Genre: String? = null
    var Pages: String? = null
    var AgeRange: String? = null
    var Price: String? = null
    var Qty: String? = null


    constructor(title: String, description : String, isbn : String, author : String, genre : String, pages:String, ageRange:String, price:String, quantity:String) {
        this.Title = title
        this.Description = description
        this.ISBN = isbn
        this.Author = author
        this.Genre = genre
        this.Pages = pages
        this.Price = price
        this.Qty = quantity
    }

//    constructor(jsonObject: JsonObject) {
//        this.id = jsonObject.getString("_id")
//        this.title = jsonObject.getString("title")
//        this.description = jsonObject.getString("description")
//        this.isbn = jsonObject.getString("isbn")
//        this.author = jsonObject.getString("author")
//        this.genre = jsonObject.getString("genre")
//        this.pages = jsonObject.getInteger("pages")
//        this.ageRange = jsonObject.getString("ageRange")
//        this.price = jsonObject.getFloat("price")
//        this.quantity = jsonObject.getInteger("quantity")
//
//    }

    constructor(book: Book) {
        //.id = book.id
        this.Title = book.Title
        this.Description = book.Description
        this.ISBN = book.ISBN
        this.Author = book.Author
        this.Genre = book.Genre
        this.Pages = book.Pages
        this.AgeRange = book.AgeRange
        this.Price = book.Price
        this.Qty = book.Qty

    }
    constructor()
    constructor(book: Map.Entry<String, Any>)
}