package jewecalc.exchange

import jewecalc.Currency

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
trait CurrencyExchangeService {

  def getExchangeRateRate( from: Currency, to: Currency) : Double

}
