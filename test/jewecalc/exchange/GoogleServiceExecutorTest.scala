package jewecalc.exchange

import org.junit.Test
import org.junit.Assert._
import jewecalc.Currency._
import org.hamcrest.core.Is._

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class GoogleServiceExecutorTest {

  val executor = new GoogleServiceExecutor

  @Test def createUrl ()  {
    assertThat(executor.createUrl( USD, EUR), is("http://www.google.com/ig/calculator?hl=en&q=1USD=EUR"))
  }

  @Test def executeGoogleService () {
    val json = executor.getRateData( USD, EUR )
    println(json)
  }

}
