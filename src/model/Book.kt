package model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Book {

   // var id: String? = null
   @JsonProperty("Title")
    var Title: String? = null

    @JsonProperty("Description")
    var Description: String? = null

    @JsonProperty("ISBN")
    var ISBN: Long = 0

    @JsonProperty("Author")
    var Author: String? = null

    @JsonProperty("Genre")
    var Genre: String? = null

    @JsonProperty("Pages")
    var Pages: String? = null

    @JsonProperty("AgeRange")
    var AgeRange: String? = null

    @JsonProperty("Price")
    var Price: String? = null

    @JsonProperty("Qty")
    var Qty: Int = 0



    constructor(title: String, description : String, isbn : Long, author : String, genre : String, pages:String, ageRange:String, price:String, quantity:Int) {
        this.Title = title
        this.Description = description
        this.ISBN = isbn
        this.Author = author
        this.Genre = genre
        this.Pages = pages
        this.Price = price
        this.Qty = quantity
    }

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