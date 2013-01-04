package jewecalc


/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
object CalculatorHelper {
  def calculate( sMaterial:String, sUnit: String , sWeight: String, sProbe: String, sCurrency: String )={
    val material = Material valueOf sMaterial
    val unit = Unit valueOf sUnit
    val weight = sWeight.toDouble
    val probe = sProbe.toInt
    val currency = Currency valueOf sCurrency

    val price = new Calculator().calculatePrice( (material, unit, currency, probe, weight) )

    ((price.microCents.toDouble / 1000).round.toDouble / 100).toString
  }
}
