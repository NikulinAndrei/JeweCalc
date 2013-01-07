package jewecalc.cache

import net.sf.ehcache.CacheManager

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 7.01.13
 */
private[cache] object Cache {
  CacheManager.getInstance().addCache("default")
  val defaultCache = CacheManager.getInstance().getCache("default")
}
