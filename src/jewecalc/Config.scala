package jewecalc

import java.util.Properties

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 10.01.13
 */
class Config {

}
object Config{
  private val props = new Properties()
  props.load( classOf[Config].getResourceAsStream("/settings.properties") )

  def getConfParam( name: String ) = {
    Config.props.getProperty( name )
  }
}
