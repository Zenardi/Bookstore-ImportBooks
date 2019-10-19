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
    var ISBN: String? = null

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