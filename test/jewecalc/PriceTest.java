package jewecalc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
public class PriceTest {
    @Test public void g_to_g_ToUnit() {
        Price p1 = new Price(Unit.g, 100L, Currency.USD);
        assertThat( p1.toUnit( Unit.g), is( p1 ));
    }

    @Test public void oz_to_oz_ToUnit() {
        Price p1 = new Price(Unit.oz, 100L, Currency.USD);
        assertThat( p1.toUnit( Unit.oz), is( p1 ));
    }

    @Test public void oz_to_g_ToUnit() {
        Price p1 = new Price(Unit.oz, 100L, Currency.USD);
        Price p2 = p1.toUnit( Unit.g);
        assertThat( p2.unit(), is( Unit.g ));
        assertThat( p2.microCents(), is( 3L ));
    }

    @Test public void g_to_oz_ToUnit() {
        Price p1 = new Price(Unit.g, 100L, Currency.USD);
        Price p2 = p1.toUnit( Unit.oz);
        assertThat( p2.unit(), is( Unit.oz ));
        assertThat( p2.microCents(), is( 3110L ));
    }
}
