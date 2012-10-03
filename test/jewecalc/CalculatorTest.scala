package jewecalc

import org.junit.{Before, Test}
import org.junit.Assert._

import org.hamcrest.CoreMatchers._

import org.mockito.Mockito._
import Currency._
import Unit._
import Material._

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class CalculatorTest {
  var calculator = new Calculator

  @Before def setupCalculator() {
    calculator = new Calculator
    calculator.service = mock( classOf[PacketizerQuoteService] )
    when( calculator.service.getPrice( GOLD )).thenReturn( new Price(g, 50000000, USD))
  }

  @Test def test_calculate(){
    val price = calculator.calculatePrice( (GOLD, g, USD, 585, 3.5) )
    assertThat(price.currency, is(USD))
    assertThat(price.unit, is(g))
    assertThat(price.microCents, is(102375000L))
  }

  @Test def test_calculateAndTransformToG(){
    when( calculator.service.getPrice( GOLD )).thenReturn( new Price(oz, 1750000000, USD))

    val price = calculator.calculatePrice( (GOLD, g, USD, 585, 3.5) )
    assertThat(price.currency, is(USD))
    assertThat(price.unit, is(g))
    assertThat(price.microCents, is(115200142L))
  }

}
