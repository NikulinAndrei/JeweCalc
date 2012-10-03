package jewecalc

import scala.util.parsing.json._

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class PacketizerQuoteService extends QuoteService{

  def getPrice(material: Material) = {
    val priceInDollars = parseJson( readFromRemoteService() ).get( material.name().toLowerCase )

    new Price(Unit.oz, (priceInDollars.get.toDouble * 100).toLong * 1000, Currency.USD)
  }

  private def readFromRemoteService() ={
    io.Source.fromURL("http://services.packetizer.com/spotprices/?f=json").mkString //ToDo: Hardcoded
  }

  private def parseJson(jsonString:String)={
    JSON.parseFull(jsonString).get.asInstanceOf[Map[String,String]]
  }

}
