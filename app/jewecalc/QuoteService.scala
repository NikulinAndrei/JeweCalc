package jewecalc

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
trait QuoteService {

  def getPrice( material: Material) : Price

}
