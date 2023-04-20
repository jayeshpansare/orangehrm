package data;

import org.testng.annotations.DataProvider;

public class loginData {
    @DataProvider(name="loginInvalid")
    public Object[][] loginInvalidData(){
        return new Object[][] {{"Test", "Test"}};

    }

    @DataProvider(name="loginvalid")
    public Object[][] loginvalidData(){
        return new Object[][] {{"Admin", "admin123"}};

    }
}
