package jewecalc.exchange

import reflect.BeanProperty

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
class GoogleServiceResponse( @BeanProperty val rhs: String){
  require(rhs!=null && !rhs.isEmpty, "rhs should be not empty")

  override def toString: String = {
    rhs
  }

  def getExchangeRate = { rhs.split(" ")(0).toDouble }
}
