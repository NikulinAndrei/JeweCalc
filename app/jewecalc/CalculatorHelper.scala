package jewecalc

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
object CalculatorHelper {
  def calculate( sMaterial:String, sUnit: String , sWeight: String, sProbe: String )={
    val material = Material.valueOf(sMaterial)
    val unit = Unit.valueOf(sUnit)
    val weight = sWeight.toDouble
    val probe = sProbe.toInt

    val price = new Calculator().calculatePrice( (material, unit, Currency.USD, probe, weight) )

    ((price.microCents.toDouble / 1000).round.toDouble / 100).toString
  }
}
