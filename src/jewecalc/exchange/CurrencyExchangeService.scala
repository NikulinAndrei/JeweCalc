package jewecalc.exchange

import jewecalc.Currency
import jewecalc.service.{CacheableBackendService, Cacheable}
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class CurrencyExchangeService extends GoogleExchangeRateService with CacheableBackendService[Currency, Double] {

  def getUsdExchangeRate( to: Currency) = {
    getCachedOrFromService( to )
  }

}
