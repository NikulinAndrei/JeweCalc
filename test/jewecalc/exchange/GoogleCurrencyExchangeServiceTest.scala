package jewecalc.exchange

import org.junit.{Test, Before}
import org.junit.Assert._
import jewecalc.Currency._
import org.hamcrest.core.Is._
import org.mockito.Mockito._

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class GoogleCurrencyExchangeServiceTest {

  var service : CurrencyExchangeService = null

  @Before def setup() {
    val executor : GoogleServiceExecutor = mock( classOf[GoogleServiceExecutor] )
    when( executor.getRateData(USD, EUR)).thenReturn(new GoogleServiceResponse("0.75 Euros"))
    service = new CurrencyExchangeService (  executor )
  }

  @Test def testGetExchaneRate() {
    assertThat( service.getExchangeRateRate(USD, EUR), is(0.75) )
  }
}