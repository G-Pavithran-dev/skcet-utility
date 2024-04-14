package com.skcet.seleniumdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:5173/")
@RestController
public class ApiController {

    @GetMapping("/portal-login")
    public String login(@RequestParam String user_email, @RequestParam String user_password) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("user-data-dir=C:\\Users\\Pavithran\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Profile 2");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://skcet530.examly.io/login");

        try {
            Thread.sleep(7000);

            if (driver.getCurrentUrl().equalsIgnoreCase("https://skcet530.examly.io/dashboard")) {
                driver.close();
                return "Already Logged In";
            }

            driver.findElement(By.id("email")).sendKeys(user_email);
            driver.findElement(By.tagName("app-button")).click();

            Thread.sleep(5000);
            driver.findElement(By.id("password")).sendKeys(user_password);

            driver.findElement(By.tagName("app-button")).click();
            Thread.sleep(5000);

            return "Login Successful";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "login unsuccessful - Internal Server Error";
        }
    }

    @GetMapping("/wifi-login")
    public String wifi(@RequestParam String username, @RequestParam String password) {
        WebDriver driver = new ChromeDriver();
        System.out.println(username + " " + password);
        try {
            driver.get("http://172.16.64.5:2280/cportal/ip/user_login.php?url=http://172.16.58.100/");
            Thread.sleep(5000);
            driver.switchTo().frame(0);

            driver.findElement(By.cssSelector("#usrname")).sendKeys(username);
            driver.findElement(By.cssSelector("#newpasswd")).sendKeys(password);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById(\"terms\").click()");
            js.executeScript("document.getElementById(\"update_btn\").click()");
            Thread.sleep(5000);
            driver.close();

            return "WIFI LOGIN successful";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "wifi login unsuccessful";
        }
    }
}
