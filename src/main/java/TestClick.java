import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;как работает браузер этапы открытия страницы DNS
//import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClick {
    AppiumDriver driver;

    @BeforeClass
//    @Test
    public void setUp() throws Exception {
        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Honor 8X");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        //        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

//        capabilities.setCapability("appPackage","com.epicpixel.rpgclicker");
//        capabilities.setCapability("appActivity","com.epicpixel.game.MainActivity");

//        capabilities.setCapability(MobileCapabilityType.UDID, "9YHNW18A08001345");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
//        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.android.contacts");
//        capabilities.setCapability("appPackage", "com.android.contacts");


        System.out.println("Шаг 1. Создаем драйвер");
        driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//
    }
    @Test
    public void testExample(){
//        здесь будет сам тест
        WebElement five=driver.findElement(MobileBy.id("com.android.calculator2:id/digit_5"));
        WebElement plus=driver.findElement(MobileBy.id("com.android.calculator2:id/op_add"));
        WebElement three=driver.findElement(MobileBy.id("com.android.calculator2:id/digit_3"));
        WebElement four=driver.findElement(MobileBy.id("com.android.calculator2:id/digit_4"));
//        WebElement plus=driver.findElement(MobileBy.name("+"));
        WebElement equalTo=driver.findElementByAccessibilityId("равно");
        five.click();
        plus.click();
        three.click();
        plus.click();
        four.click();
        equalTo.click();

        WebElement formula = driver.findElement(MobileBy.id("com.android.calculator2:id/formula"));
        Assert.assertTrue(formula.getText().equals("12"));
//        driver.findElementById("com.android.calculator2:id/digit_5").click();

//        System.out.println("Шаг 2. Первое нажатие на 300 300");
//        driver.tap(1,300,300,1);
//        Thread.sleep(1000);
//        int count = 1000;
//        System.out.println("Шаг 3. Второе нажатие на 300 300 (" + count + " раз)");
//        for(int i =0; i < count; ++i){
//            driver.tap(1,300,300,1);
//        }
//        Thread.sleep(100);
//        System.out.println("Шаг 4. Закрываем драйвер");
//        driver.quit();
    }

//    @Test
//    public void testExample2(){
//        System.out.println("Шаг 2. Ожидание 10 секунд");
////        WebDriverWait wdw = new WebDriverWait(driver, 20);
//        System.out.println("Шаг 3. Нажимаем кнопку на экране по координате x:300 y:300");
//        System.out.println("Шаг 2. Выбираем поисковую систему Яндекс");
//        driver.findElement(MobileBy.linkText("Яндекс")).click();
//        System.out.println("Шаг 2.1. Нажимаем ОК");
//        driver.findElementById("com.android.chrome:id/button_primary").click();
//
//        System.out.println("Шаг 3. Открываем http://ya.ru/");
//        driver.get("http://www.ya.ru/");
//
//        System.out.println("Шаг 4. Закрываем драйвер");
//        driver.closeApp();
//    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.quit();  // CloseApp() метод используется для закрытия нативного или гибридного приложения,
//        // а quit() и close() - для веб приложения
//    }

    @AfterClass
    public void tearDown(){
        driver.closeApp();  // CloseApp() метод используется для закрытия нативного или гибридного приложения,
                            // а quit() и close() - для веб приложения
    }
}
