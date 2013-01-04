package jewecalc.quote;

import jewecalc.Material;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 4.01.13
 */
public class QuoteServiceTest {

  @Test public void test(){
    QuoteService service = new QuoteService();
    System.out.println( service.getPrice( Material.GOLD ) );
    System.out.println( service.getPrice( Material.GOLD ) );
    System.out.println( service.getPrice( Material.GOLD ) );
    System.out.println( service.getPrice( Material.SILVER ) );
    System.out.println( service.getPrice( Material.GOLD ) );
    System.out.println( service.getPrice( Material.SILVER ) );
  }
}
