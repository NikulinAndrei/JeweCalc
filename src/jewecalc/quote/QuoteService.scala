package jewecalc.quote

import jewecalc.service.CacheableBackendService
import jewecalc.{Price, Material}


/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
class QuoteService extends PacketizerQuoteService with CacheableBackendService[Material, Price]{
  def getPrice( material: Material) = this.getCachedOrFromService( material )
}