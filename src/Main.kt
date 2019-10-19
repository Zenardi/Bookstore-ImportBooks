import util.CsvParser
import util.JsonParser

fun main(args: Array<String>) {

    //val csvParser : CsvParser = CsvParser()
    //var csvParsed = csvParser.readCsvFileKotlin("C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\books.csv")

    val jsonParser:JsonParser = JsonParser()
    jsonParser.readJsonFileKotlin("C:\\Users\\duzen\\source\\repos\\Bookstore-ImportBooks\\src\\TestFiles\\books_mod.json")
}