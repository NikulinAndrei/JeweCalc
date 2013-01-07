package jewecalc.service

import net.sf.ehcache.Element

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 7.01.13
 */
trait Cacheable [K, V] {

  def putToCache( key: K, value: V){
    Cache.defaultCache.put(new Element(key, value))
  }


  def getFromCache(key: K) = {
    val cached = Cache.defaultCache.get(key)

    if (cached == null)
      None
    else
      Option( cached.getObjectValue.asInstanceOf[V] )
  }
}