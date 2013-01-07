package jewecalc.exchange

import jewecalc.Currency
import jewecalc.cache.Cacheable
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class CurrencyExchangeService private[exchange]( val executor : GoogleServiceExecutor )
  extends Cacheable[Currency, Double]{

  private val log = LoggerFactory.getLogger( classOf[CurrencyExchangeService])

  def this() = { this( new GoogleServiceExecutor)  }


  def getExchangeRateRate(from: Currency, to: Currency) = {
    val rate = getFromCache( to )

    val result = if ( rate.isDefined ){
      log.debug( "Returning cached rate for {}", to)
      rate.get
    }
    else{
      log.debug( "cache miss, {}", to)
      val caclulatedRate = executor.getRateData(from, to).getExchangeRate
      putToCache(to, caclulatedRate)
      caclulatedRate
    }

    result
  }

}
