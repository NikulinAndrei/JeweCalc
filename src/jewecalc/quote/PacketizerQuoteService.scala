package jewecalc.quote

import scala.util.parsing.json._
import jewecalc.Currency._
import jewecalc.{Config, Price, Material}
import jewecalc.Unit._
import org.slf4j.LoggerFactory
import jewecalc.service.BackendService

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
private[quote] trait PacketizerQuoteService extends BackendService[Material, Price] {

  private val log = LoggerFactory.getLogger( classOf[PacketizerQuoteService])
  private val DEFAULT_CURRENCY = USD


  def executeBackendService(material: Material): Price = {
    log.debug("Executing Packetizer service for {}", material)
    val priceInDollars = parseJson( readFromRemoteService() ).get( material.name().toLowerCase )

    new Price( oz, (priceInDollars.get.toDouble * 100).toLong * 1000, DEFAULT_CURRENCY)
  }

  private def readFromRemoteService() ={
    io.Source.fromURL( Config.getConfParam("packetizer.endpoint") ).mkString
  }

  private def parseJson(jsonString:String)={
    JSON.parseFull(jsonString).get.asInstanceOf[Map[String,String]]
  }

}
