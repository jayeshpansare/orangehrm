package testcases;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import data.loginData;
import lib.BaseClass;
import lib.FindBrokenLinks;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.ValidateLoginSteps;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.sql.SQLOutput;

public class TC_01_ValidateLogin extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_01_ValidateLogin.class);
   @Test(priority = 1, groups = {"smoke"})
    public void verifyTitle(){
      Assert.assertEquals(getDriver().getTitle(), "OrangeHRM");
      log.info("verify titles");
    }
    @Test(priority = 2, groups = {"smoke"})
    public void verifyBrokenLinks() throws IOException {
        //FindBrokenLinks getBrokenLink= new FindBrokenLinks();
        //getBrokenLink.findBrokenLink(getDriver());
        //log.info("verify broken links");
    }

    @Test(priority = 3, groups = {"smoke"})
    public void validateLogo(){
        ValidateLoginSteps objValidateLoginSteps = new ValidateLoginSteps(getDriver());
       // Assert.assertTrue(objValidateLoginSteps.verifyWebSiteLogo());
   }
   @Test(priority = 4)
    public void validateLoginPage(){
       ValidateLoginSteps objValidateLoginSteps = new ValidateLoginSteps(getDriver());
       Assert.assertEquals(objValidateLoginSteps.getLoginPageTitle(), "Login");
       Assert.assertEquals(objValidateLoginSteps.getUserLabels(),"Username");
       Assert.assertEquals(objValidateLoginSteps.getPasswordLabels(), "Password");
       Assert.assertEquals(objValidateLoginSteps.getLoginBtnLabel(),"Login");
       Assert.assertEquals(objValidateLoginSteps.getForPasswordLik(),"Forgot your password?");
        Assert.assertEquals(objValidateLoginSteps.getMeg1(),"OrangeHRM OS 5.3");
       Assert.assertEquals(objValidateLoginSteps.getMeg2(),"© 2005 - 2023 OrangeHRM, Inc. All rights reserved.");
    }
    @Test(priority = 5, dataProvider = "loginInvalid", dataProviderClass = loginData.class)
    public void validateLoginPageWithInvalid(String username, String passWord){
        ValidateLoginSteps objValidateLoginSteps = new ValidateLoginSteps(getDriver());
        objValidateLoginSteps.setLoginInputs(username, passWord);
        Assert.assertEquals(objValidateLoginSteps.getLoginErrorMessage(),"Invalid credentials");
    }

    @Test(priority = 6, dataProvider = "loginvalid", dataProviderClass = loginData.class)
    public void validateLoginPageWithvalid(String username, String passWord){
        ValidateLoginSteps objValidateLoginSteps = new ValidateLoginSteps(getDriver());
        objValidateLoginSteps.setLoginInputs(username, passWord);
    }
}
