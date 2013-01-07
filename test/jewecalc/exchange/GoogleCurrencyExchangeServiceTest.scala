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
    service = spy( new CurrencyExchangeService ( ) )
    when( service.getRateData(USD, EUR)).thenReturn(new GoogleServiceResponse("0.75 Euros"))
  }

  @Test def testGetExchaneRate() {
    assertThat( service.getUsdExchangeRate( EUR ), is(0.75) )
  }
}