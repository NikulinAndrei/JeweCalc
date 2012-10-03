package jewecalc

import  Unit._
/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class Price (val unit: Unit, val microCents: Long, val currency: Currency){
  override def toString = microCents + " " + currency + " microCents / "+ unit

  def toUnit( newUnit: Unit ) = {
    newUnit match{
      case this.unit => this
      case Unit.g => new Price( newUnit, (microCents/ Price.GRAMS_IN_OZ).toLong, currency )
      case Unit.oz => new Price( newUnit, (microCents* Price.GRAMS_IN_OZ).toLong, currency )
    }
  }

  def toDouble() = (microCents/1000).toDouble / 100
}

object Price{
  val GRAMS_IN_OZ = 31.1034768
}
