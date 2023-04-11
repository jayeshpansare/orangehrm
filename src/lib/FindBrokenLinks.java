package lib;

import com.github.dockerjava.api.model.Link;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcases.TC_01_ValidateLogin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindBrokenLinks {
    private static final Logger log = LogManager.getLogger(FindBrokenLinks.class);
    public void findBrokenLink(WebDriver driver) throws IOException {
        List<WebElement> getAlllinks =driver.findElements(By.tagName("a"));
        if(!getAlllinks.isEmpty()){
            for (WebElement getAlllink : getAlllinks) {
                String getURL = getAlllink.getAttribute("href");

                URL url = new URL(getURL);
                HttpURLConnection ht = (HttpURLConnection) url.openConnection();
                ht.connect();
                int getResponseCode = ht.getResponseCode();
                if(getResponseCode>=400){
                    System.out.println(getURL + " Is a broken link");
                    log.error("Broken link is - "+getURL+" Status code is "+getResponseCode);
                }else {
                    System.out.println(getURL + " Is not broken link");
                    log.info("Not Broken link is - "+getURL+" Status code is "+getResponseCode);
                }
            }
        }
    }
}
