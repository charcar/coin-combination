import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void coinCounter_oneCentEqualsOnePenny_onePenny() {
    App testApp = new App();
    assertEquals("0 quarter, 0 dime, 0 nickel and 1 penny.", testApp.coinCounter(1));
  }

  @Test
  public void coinCounter_fiveCentsEqualsOneNickel_oneNickel() {
    App testApp = new App();
    assertEquals("0 quarter, 0 dime, 1 nickel and 0 penny.", testApp.coinCounter(5));
  }

  @Test
  public void coinCounter_eightCentsEqualsOneNickelThreePennies_oneNickelThreePennies() {
    App testApp = new App();
    assertEquals("0 quarter, 0 dime, 1 nickel and 3 pennies.", testApp.coinCounter(8));
  }

  @Test
  public void coinCounter_seventeenCentsEqualsOneDimeOneNickelTwoPennies_oneDimeOneNickelTwoPennies() {
    App testApp = new App();
    assertEquals("0 quarter, 1 dime, 1 nickel and 2 pennies.", testApp.coinCounter(17));
  }

  @Test
  public void coinCounter_fortyfourCentsEqualsOneQuarterOneDimeOneNickelFourPennies_oneQuarterOneDimeOneNickelFourPennies() {
    App testApp = new App();
    assertEquals("1 quarter, 1 dime, 1 nickel and 4 pennies.", testApp.coinCounter(44));
  }

  @Test
  public void coinCounter_sixtynineCentsEqualsTwoQuartersOneDimeOneNickelFourPennies_oneQuarterOneDimeOneNickelFourPennies() {
    App testApp = new App();
    assertEquals("2 quarters, 1 dime, 1 nickel and 4 pennies.", testApp.coinCounter(69));
  }
}
