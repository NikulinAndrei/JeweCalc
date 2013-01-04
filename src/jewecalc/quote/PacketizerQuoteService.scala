package jewecalc.quote

import scala.util.parsing.json._
import jewecalc.Currency._
import jewecalc.{Price, Material}
import jewecalc.Unit._
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
private[quote] trait PacketizerQuoteService extends AbstractQuoteService {

  private val log = LoggerFactory.getLogger( classOf[PacketizerQuoteService])

  private val DEFAULT_CURRENCY = USD

  override def getPrice(material: Material) = {
    log.debug("Executing Packetizer service for {}", material)
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
