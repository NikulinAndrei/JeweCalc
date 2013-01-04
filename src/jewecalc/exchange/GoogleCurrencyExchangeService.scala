package jewecalc.exchange

import jewecalc.Currency

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class GoogleCurrencyExchangeService private[exchange]( val executor : GoogleServiceExecutor )
  extends CurrencyExchangeService{

  def this() = { this( new GoogleServiceExecutor)  }


  def getExchangeRateRate(from: Currency, to: Currency) = {
    executor.getRateData(from, to).getExchangeRate
  }
}
