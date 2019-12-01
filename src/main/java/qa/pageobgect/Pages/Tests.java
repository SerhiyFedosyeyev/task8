package qa.pageobgect.Pages;

import org.junit.Test;

public class Tests extends BaseTest {
    public Tests(BaseTest basetest) {
        super(basetest);
    }
    @Test
    public void openHomehage(){
     LoginPage loginPage = openSite();
     closeSite();
    }
}
