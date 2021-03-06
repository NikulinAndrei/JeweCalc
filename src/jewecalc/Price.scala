package jewecalc

import exchange.CurrencyExchangeService
import Price._
import reflect.BeanProperty

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class Price (val unit: Unit, val microCents: Long, val currency: Currency){
  override def toString = microCents + " " + currency + " microCents / "+ unit

  @BeanProperty var exchangeService = new CurrencyExchangeService

  def toUnit( newUnit: Unit ) = {
    newUnit match{
      case this.unit => this
      case Unit.g => new Price( newUnit, (microCents / GRAMS_IN_OZ).toLong, currency )
      case Unit.oz => new Price( newUnit, (microCents * GRAMS_IN_OZ).toLong, currency )
    }
  }

  def toCurrency( newCurrency: Currency ) = {
    newCurrency match{
      case this.currency => this
      case _ => {
        val exchangeRate = exchangeService.getUsdExchangeRate( newCurrency )
        new Price( unit, (microCents * exchangeRate).round, newCurrency)
      }
    }
  }

  def toDouble() = (microCents.toDouble/1000).round.toDouble / 100

  def asMoney() = {
    String.valueOf( toDouble() )
  }
}

object Price{
  val GRAMS_IN_OZ = 31.1034768
}