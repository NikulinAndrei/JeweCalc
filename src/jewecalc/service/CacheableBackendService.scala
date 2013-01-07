package jewecalc.service

import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 7.01.13
 */
trait CacheableBackendService[K,V] extends Cacheable[K,V]
{ self: BackendService[K, V] =>

  private val log = LoggerFactory.getLogger( this.getClass )

  def getCachedOrFromService( to: K) = {
    val cached = getFromCache( to )

    val result = if ( cached.isDefined ){
      log.debug( "Returning cached rate for {}", to)
      cached.get
    }
    else{
      log.debug( "service miss, {}", to)
      val caclulated = executeBackendService( to )
      putToCache(to, caclulated)
      caclulated
    }

    result
  }
}
