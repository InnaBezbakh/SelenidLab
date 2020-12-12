package SelenidOpen;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class InputForm1 {

    //Before
    By closeButton = By.xpath("//*[@id='at-cv-lightbox-close']");

    //test_1
    By inputFormOptionBy = By.xpath("//a[text()='Input Forms']");
    By waitSimpleFormDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By singleInputFieldBy = By.xpath("//input[@id='user-message']");
    By buttonShowMessageBy = By.xpath("//button[text()='Show Message']");
    By actualResultBy = By.xpath("//span[@id='display']");

    //test_2
    By actualResult1By = By.xpath("//span[@id='displayvalue']");

    //tst_3
    By waitCheckBoxDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
    By checkBoxOption1By = By.xpath("//label[text()='Option 1']//input");
    By checkBoxOption3By = By.xpath("//label[text()='Option 3']//input");

    //test_4
    By waitRadiobuttonDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']");
    By radioButtonSexMaleBy = By.xpath("//label[text()='Male']");
    By radioButtonAgeGroupBy = By.xpath("//label[text()='15 to 50']");
    By buttonGetValuesBy = By.xpath("//button[text()='Get values']");
    By actualRes5By = By.xpath("//p[@class='groupradiobutton']");

    //test_5
    By waitSelectDropdownListBy = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    By selectListDemoOptionFridayBy = By.xpath("//select[@id='select-demo']//option[@value='Friday']");
    By actualRes6By = By.xpath("//p[text()='Day selected :- Friday']");

    //test_6
    By multiSelectListDemoFloridaBy = By.xpath("//select[@id='multi-select']//option[text()='Florida']");
    By multiSelectListDemoNewYorkBy = By.xpath("//select[@id='multi-select']//option[text()='New York']");
    By buttonGetAllSelectedBy = By.xpath("//button[@id='printAll']");

    //test_7
    By waitAjaxFormSubmitBy = By.xpath("//li[@class='tree-branch']//a[text()='Ajax Form Submit']");
    By clickSubmitButtonBy = By.xpath("//input[@id='btn-submit']");
    By actRes8By = By.xpath("//input[@id='title']");

    //test_8
    By datePickersBy = By.xpath("//a[text()='Date pickers']");
    By waitBootstrapDatePickerBy = By.xpath("//li[@class='tree-branch']//a[text()='Bootstrap Date Picker']");
    By chooseDateBy = By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']");


    @BeforeClass
    public static void beforeClass() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //WebDriverRunner.setWebDriver(driver);
        //Configuration.browser = "chrome";= new ChromeDriver();

        //Configuration.browser = "safari";
        //Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }


    @Before
    public void beforeEachTest() {
        try {
            WebDriver webDriver = WebDriverRunner.getWebDriver();
            WebDriverWait wait = new WebDriverWait(webDriver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();
        }
        catch(Exception e){
            System.out.println("Window is not open");
        }
        open("https://www.seleniumeasy.com/test");
        $(closeButton).waitUntil(visible, 5000).click();
    }

    @Test
    public void test_1() {
        $(inputFormOptionBy).click();
        $(waitSimpleFormDemoBy).click();
        $(singleInputFieldBy).click();
        $(singleInputFieldBy).setValue("Hello, my name is");
        $(buttonShowMessageBy).click();
        $(actualResultBy).shouldHave(text("Hello, my name is"));
    }
    @Test
    public void test_2(){
        $(inputFormOptionBy).click();
        $(waitSimpleFormDemoBy).click();
        $(By.xpath("//input[@id='sum1']")).setValue("200");
        $(By.xpath("//input[@id='sum2']")).setValue("2");
        $(By.xpath("//button[text()='Get Total']")).click();
        $(actualResult1By).shouldHave(text("202"));
    }
    @Test
    public void test_3(){
        $(inputFormOptionBy).shouldBe(visible).click();
        $(waitCheckBoxDemoBy).shouldBe(visible).click();
        $(checkBoxOption1By).shouldBe(visible).setSelected(true);
        $(checkBoxOption3By).shouldBe(visible).setSelected(true);
        $(checkBoxOption1By).shouldBe(selected);
        $(checkBoxOption3By).shouldBe(selected);
    }

    @After
    public void afterEachTest(){
        WebDriverRunner.getWebDriver().quit();
    }


}
