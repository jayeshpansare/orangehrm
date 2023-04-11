package testcases;

import lib.BaseClass;
import lib.FindBrokenLinks;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01_ValidateLogin extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_01_ValidateLogin.class);
   @Test(priority = 1, groups = {"smoke"})
    public void verifyTitle(){
      Assert.assertEquals(getDriver().getTitle(), "OrangeHRM");
      log.info("verify titles");
    }
    @Test(priority = 2, groups = {"smoke"})
    public void verifyBrokenLinks() throws IOException {
        FindBrokenLinks getBrokenLink= new FindBrokenLinks();
        getBrokenLink.findBrokenLink(getDriver());
        log.info("verify broken links");
    }
    @Test(priority = 3, groups = {"smoke"})
    public void validateLoginPageUI(){

    }
}
