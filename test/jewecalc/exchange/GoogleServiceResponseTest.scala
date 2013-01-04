package jewecalc.exchange

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.core.Is

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class GoogleServiceResponseTest{

  @Test def test_getRate() {
    val resp1 = new GoogleServiceResponse( "0.75 Euros")
    assertThat( resp1.getExchangeRate, Is.is(0.75))
  }

}
