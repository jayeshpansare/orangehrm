package stepDefination;

import lib.PageAction;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateLoginSteps extends PageAction {

    private final WebDriver driver;

    public ValidateLoginSteps(WebDriver driver) {
        this.driver = driver;
    }
    By webSiteLogo = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img");
    By loginPageTitle = By.xpath("//div[@class=\"orangehrm-login-slot\"]/h5");
    By loginUserNameLabel = By.xpath("//form[@class=\"oxd-form\"]/div/div/div/label");
    By loginUserNameInput = By.xpath("//form[@class=\"oxd-form\"]/div/div/div[2]/input");
    By loginPasswordLabel = By.xpath("//form[@class=\"oxd-form\"]/div[2]/div/div/label");
    By loginPasswordInput = By.xpath("//form[@class=\"oxd-form\"]/div[2]/div/div[2]/input");
    By loginBtn = By.xpath("//form[@class=\"oxd-form\"]/div[3]/button");
    By forgotPasswordLink = By.xpath("//div[@class=\"orangehrm-login-forgot\"]/p");
    By errorMsg = By.xpath("//div[@class=\"orangehrm-login-error\"]/div/div/p");
    By footerOrgMsg = By.xpath("//div[@class=\"orangehrm-copyright-wrapper\"]/p");
    By getFooterOrgMsg1 = By.xpath("//div[@class=\"orangehrm-copyright-wrapper\"]/p[2]");

    public boolean verifyWebSiteLogo() {
        WaitActions objWait = new WaitActions();
        objWait.presenceOfElementLocatedEle(driver, 10, webSiteLogo);
        return isLocatorPresent(driver, webSiteLogo);
    }
    public String getLoginPageTitle(){
        return getElementText(driver, loginPageTitle);
    }

    public String getUserLabels() {
        return getElementText(driver, loginUserNameLabel);
    }
    public String getPasswordLabels() {
        return getElementText(driver, loginPasswordLabel);
    }

    public String getLoginBtnLabel(){
        return getElementText(driver, loginBtn);
    }
    public String getForPasswordLik(){
        return getElementText(driver, forgotPasswordLink);
    }
    public String getMeg1() {
        return getElementText(driver, footerOrgMsg);
    }
    public String getMeg2(){
        return getElementText(driver, getFooterOrgMsg1);
    }

    public void setLoginInputs(String username, String passWord) {
        clearInput(driver, loginUserNameInput);
        sendInput(driver, loginUserNameInput,username);
        clearInput(driver, loginPasswordInput);
        sendInput(driver, loginPasswordInput, passWord);
        clickOnElement(driver, loginBtn);
    }

    public String getLoginErrorMessage() {
        return getElementText(driver, errorMsg);
    }
}
