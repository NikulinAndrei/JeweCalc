package jewecalc

import scala.util.parsing.json._
import Unit._
import Currency._

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class PacketizerQuoteService extends QuoteService{
  private val DEFAULT_CURRENCY = USD

  def getPrice(material: Material) = {
    val priceInDollars = parseJson( readFromRemoteService() ).get( material.name().toLowerCase )

    new Price( oz, (priceInDollars.get.toDouble * 100).toLong * 1000, DEFAULT_CURRENCY)
  }

  private def readFromRemoteService() ={
    io.Source.fromURL("http://services.packetizer.com/spotprices/?f=json").mkString //ToDo: Hardcoded
  }

  private def parseJson(jsonString:String)={
    JSON.parseFull(jsonString).get.asInstanceOf[Map[String,String]]
  }

}
