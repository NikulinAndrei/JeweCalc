package jewecalc.quote

import jewecalc.{Price, Material}
import org.slf4j.LoggerFactory
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
private [quote] trait CacheQuoteService extends AbstractQuoteService{
  private val log = LoggerFactory.getLogger( classOf[CacheQuoteService])


  override def getPrice(material: Material): Price = {
    val price = CacheQuoteService.cache.get( material )

    val result = if ( price.isDefined ){
      log.debug( "Returning cached price for {}", material)
      price.get
    }
    else{
      log.debug( "cache miss, ", material)
      val price = super.getPrice( material)
      CacheQuoteService.cache(material) = price
      price
    }

    result
  }
}

private object CacheQuoteService{
  val cache = mutable.Map.empty[Material, Price]
}
