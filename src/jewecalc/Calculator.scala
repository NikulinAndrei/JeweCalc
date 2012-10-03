package jewecalc

import org.slf4j.{LoggerFactory, Logger}

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class Calculator {
  private val log = LoggerFactory.getLogger( this.getClass )

  var service = new QuoteService

  def calculatePrice( request: Tuple5[Material, Unit, Currency, Int, Double] ) ={

    val (material, unit, currency, probe, weight) = request
    log.info("BEGIN calculation: "+weight+" " +unit + " of " +probe+"-probe " + material+", in " + currency )

    val pricePerUnit = service.getPrice( material ).toUnit( unit )

    val calculatedPriceInMicrocents = pricePerUnit.microCents * weight * (probe.toDouble/1000)

    val  result = new Price(unit, calculatedPriceInMicrocents.toLong, currency)
    log.info("END calculation: " + material+" PRICE is  " + result )
    result
  }


}

