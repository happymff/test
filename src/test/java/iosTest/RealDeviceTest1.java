package iosTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class RealDeviceTest1 {
    IOSDriver driver;
    InitializeDriverRealDevice1 initialize;

    @BeforeMethod
    public void setUp() throws Exception {

        initialize = new InitializeDriverRealDevice1();
        // initializing driver object
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws Exception {
        //学生账号进行登录
        int width2 = driver.manage().window().getSize().width;
        int height2 = driver.manage().window().getSize().height;
        System.out.println(width2);
        System.out.println(height2);
        for (int i = 0; i < 3; i++) {
            driver.swipe(width2 * 6 / 7, height2 / 2, width2 * 2 / 7, 0, 1000);
        }
        System.out.println("滑动成功");

        //点击登录按钮
        driver.findElement(By.className("UIAButton")).click();
        Thread.sleep(2000);
        System.out.println("点击立即登录按钮成功");

        //输入账号和密码
        driver.findElementByIosNsPredicate("value =='请输入爱学派账号'").sendKeys("AXPC11@ett.com");
        driver.findElementByIosNsPredicate("name == 'login_default_icon'").click();
        driver.findElementByIosNsPredicate("value =='请输入登录密码'").sendKeys("1111");
        driver.findElementByIosNsPredicate("name == 'login_default_icon'").click();
        driver.findElement(By.id("登录")).click();
        System.out.println("登录成功");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
