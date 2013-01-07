package jewecalc.service

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 7.01.13
 *
 * Q - Query, or Request
 * R - Response
 */
trait BackendService [Q, R] {

  def executeBackendService(query: Q) : R

}
