package jewecalc

import org.slf4j.LoggerFactory
import quote.QuoteService

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class Calculator {
  private val log = LoggerFactory.getLogger( this.getClass )

  var service = new QuoteService

  def calculatePrice( request: (Material, Unit, Currency, Int, Double) ) ={

    val (material, unit, currency, probe, weight) = request
    log.info("BEGIN calculation: "+weight+" " +unit + " of " +probe+"-probe " + material+", in " + currency )

    val pricePerUnit = service.getPrice( material ).
      toUnit( unit ).
      toCurrency(currency)

    val calculatedPriceInMicrocents = pricePerUnit.microCents * weight * (probe.toDouble/1000)

    val  result = new Price(unit, calculatedPriceInMicrocents.toLong, currency)
    log.info("END calculation: " + material+" PRICE is  " + result )
    result
  }
}

object Calculator{
  def calculate( sMaterial:String, sUnit: String , sWeight: String, sProbe: String, sCurrency: String )={
    require( sMaterial != null && !sMaterial.isEmpty, "Material is not specified")
    require( sUnit != null && !sUnit.isEmpty, "Unit is not specified")
    require( sWeight != null && !sWeight.isEmpty, "Weight is not specified")
    require( sProbe != null && !sProbe.isEmpty, "Probe is not specified")
    require( sCurrency != null && !sCurrency.isEmpty, "Currency is not specified")

    val material = Material valueOf sMaterial
    val unit = Unit valueOf sUnit
    val weight = sWeight.toDouble
    val probe = sProbe.toInt
    val currency = Currency valueOf sCurrency

    val price = new Calculator().calculatePrice( (material, unit, currency, probe, weight) )

    price.asMoney()
  }
}


