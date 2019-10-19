import model.Book
import util.CsvParser
import util.JsonParser
import java.io.File
import com.google.gson.GsonBuilder


fun main(args: Array<String>) {

    val csvParser : CsvParser = CsvParser()
    val jsonParser:JsonParser = JsonParser()

    var books = ArrayList<Book>()

    /*      CSV FILE      */
    books = csvParser.readCsvFileKotlin("C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\books.csv", books)



    /*      TAB FILE      */
    var content = File("C:\\\\Users\\\\duzen\\\\source\\\\repos\\\\Bookstore-ImportBooks\\\\src\\\\TestFiles\\\\books-tab.txt").readText()
    //remove comma from description and replace tab with comma
    var result = content.replace(",","").replace("\t", ", ")
    books = csvParser.readCsvFileKotlinContent(result, books)


    /*      JSON FILE      */
    books = jsonParser.readJsonFileKotlin("C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\books.json", books)

    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonBookList: String = gson.toJson(books)

    File("C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\books-consolidated.json").writeText(jsonBookList)

}