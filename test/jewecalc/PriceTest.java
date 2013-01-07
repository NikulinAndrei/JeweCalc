package jewecalc;

import jewecalc.exchange.CurrencyExchangeService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static jewecalc.Currency.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: andrei nikulin
 * Date: 3.10.12
 */
public class PriceTest {
  @Test  public void g_to_g_ToUnit() {
    Price p1 = new Price(Unit.g, 100L, USD);
    assertThat(p1.toUnit(Unit.g), is(p1));
  }

  @Test  public void oz_to_oz_ToUnit() {
    Price p1 = new Price(Unit.oz, 100L, USD);
    assertThat(p1.toUnit(Unit.oz), is(p1));
  }

  @Test  public void oz_to_g_ToUnit() {
    Price p1 = new Price(Unit.oz, 100L, USD);
    Price p2 = p1.toUnit(Unit.g);
    assertThat(p2.unit(), is(Unit.g));
    assertThat(p2.microCents(), is(3L));
  }

  @Test  public void g_to_oz_ToUnit() {
    Price p1 = new Price(Unit.g, 100L, USD);
    Price p2 = p1.toUnit(Unit.oz);
    assertThat(p2.unit(), is(Unit.oz));
    assertThat(p2.microCents(), is(3110L));
  }

  @Test public void usd_to_eur_ToCurency() {
    Price p1 = new Price(Unit.g, 100L, USD);
    p1.setExchangeService( mock( CurrencyExchangeService.class ));
    when(p1.getExchangeService().getUsdExchangeRate( EUR)).thenReturn(0.749912);

    Price p2 = p1.toCurrency( EUR );
    assertThat( p2.currency(), is( EUR ));
    assertThat( p2.microCents(), is( 75L ));
  }

  @Test public void usd_to_usd_ToCurency() {
    Price p1 = new Price(Unit.g, 100L, USD);
    Price p2 = p1.toCurrency( USD );
    assertThat( p2.currency(), is( USD ));
    assertThat( p2.microCents(), is( 100L ));
  }
}
