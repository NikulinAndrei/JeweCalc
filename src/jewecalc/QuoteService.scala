package jewecalc

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class QuoteService {

  def getPrice( material: Material) = {
    new Price( Unit.g, 50000, Currency.USD) // Dummy implementation
  }

}
