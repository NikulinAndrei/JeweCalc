package jewecalc.quote;

import jewecalc.Material;
import jewecalc.quote.PacketizerQuoteService;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
public class PacketizerQuoteServiceTest {

    @Test public void testGetPrice() throws Exception {
        System.out.println( new QuoteService().getPrice(Material.GOLD) );
    }
}
