package jewecalc.exchange

import jewecalc.Currency
import com.google.gson.Gson
import jewecalc.service.BackendService

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
private [exchange] trait GoogleExchangeRateService extends BackendService [Currency, Double] {

  /**
   * Implementation of BackendService
   * @param query - Currency for which the Exchange Rate is queried
   * @return - Double, the USD->Currency Exchange rate
   */
  def executeBackendService(query: Currency) = {
    getRateData(Currency.USD, query).getExchangeRate
  }

  def getRateData(from: Currency, to: Currency) = {
    val endpoint = createUrl( from, to )
    parseJson( readFromRemoteService( endpoint ) )
  }

  def createUrl( from: Currency, to: Currency ) = {
    "http://www.google.com/ig/calculator?hl=en&q=1" + from.name() +"=" + to.name() //ToDo: Hardcoded
  }

  private def readFromRemoteService( endpoint: String) = {
    io.Source.fromURL( endpoint).mkString
  }

  private def parseJson(jsonString:String)={
    new Gson().fromJson( jsonString, classOf[GoogleServiceResponse])
  }

}
