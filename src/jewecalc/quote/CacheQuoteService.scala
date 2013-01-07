package jewecalc.quote

import jewecalc.{Price, Material}
import org.slf4j.LoggerFactory
import jewecalc.cache.Cacheable

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
private [quote] trait CacheQuoteService extends AbstractQuoteService with Cacheable[Material, Price]{
  private val log = LoggerFactory.getLogger( classOf[CacheQuoteService])


  override def getPrice(material: Material): Price = {
    val price = getFromCache( material )

    val result = if ( price.isDefined ){
      log.debug( "Returning cached price for {}", material)
      price.get
    }
    else{
      log.debug( "cache miss, ", material)
      val price = super.getPrice( material)
      putToCache(material, price)
      price
    }

    result
  }
}
