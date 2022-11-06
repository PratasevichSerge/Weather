import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PratasevichSergeTest {

//    /TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(10000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id='weather-widget']//input[@placeholder='Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']//button[@type='submit']"));

        searchButton.click();
        Thread.sleep(5000);

        WebElement parisChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class ='search-dropdown-menu']/li/span[text() = 'Paris, FR ']"));

        parisChoiceInDropDownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(By.xpath(
                "//div[@id='weather-widget']//h2"));

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();


        Assert.assertEquals(actualResult, expectedResult);



//                Thread.sleep(5000);
//
        driver.quit();

    }

//    TC_11_02

    @Test
    public void testspan_WhenChangeCtoF() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "54°F";

        driver.get(url);
        Thread.sleep(10000);

        WebElement genericTemperature = driver.findElement(By.xpath(
                "//div[@class='option'][text()='Imperial: °F, mph']"
        ));

        genericTemperature.click();
        Thread.sleep(5000);

        WebElement spanCityTemperatureF = driver.findElement(By.xpath(
                "//span[@class='heading'][text()='54°F']"
        ));

        String actualResult = spanCityTemperatureF.getText();


        Assert.assertEquals(actualResult, expectedResult);

      driver.quit();
    }

//    TC_11_3

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential" +
                " cookies to help us improve our services. Any data collected is anonymised. " +
                "You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";

        driver.get(url);
        Thread.sleep(10000);

        WebElement pCookiesDescriptionIsVisible = driver.findElement(By.xpath(
                "//div[@class='stick-footer-panel__container']//p[text()=" +
                        "'We use cookies which are essential for the site to work. " +
                        "We also use non-essential cookies to help us improve our services. " +
                        "Any data collected is anonymised. You can allow all cookies or manage them individually.']"
        ));

        String actualResult = pCookiesDescriptionIsVisible.getText();

        WebElement pCookiesAllowAllButton = driver.findElement(By.xpath(
                "//div[@class='stick-footer-panel__btn-container']//button[text()='Allow all']"
        ));
        String actualResult1 = pCookiesAllowAllButton.getText();

        WebElement pCookiesManageCookies = driver.findElement(By.xpath(
                "//div[@class='stick-footer-panel__btn-container']//a"
        ));
        String actualResult2 = pCookiesManageCookies.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);


        driver.quit();
    }

//    TC_11_04

    @Test
    public void testIdDropDownHomePageGetSupportMenu() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);
        Thread.sleep(10000);

        WebElement idSupportDropDown = driver.findElement(By.xpath(
                "//li[@class='with-dropdown']"
        ));

        idSupportDropDown.click();

        WebElement menuSupportFaq = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']/li/a[text()='FAQ']"
        ));

        String actualResult = menuSupportFaq.getText();

        WebElement menuSupportHowToStart = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']/li/a[text()='How to start']"
        ));
        String actualResult1 = menuSupportHowToStart.getText();

        WebElement menuSupportAskAquestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']/li/a[text()='Ask a question']"
        ));
        String actualResult2 = menuSupportAskAquestion.getText();


        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }

    @Test
    public void testDivSupportFillUpFields() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "protas0609@mail.ru";
        String message = "Help";

        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        Thread.sleep(10000);

        WebElement idSupportDropDown = driver.findElement(By.xpath(
                "//li[@class='with-dropdown']"
        ));

        idSupportDropDown.click();

        WebElement menuSupportAskQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']/li/a[text()='Ask a question']"
        ));

        menuSupportAskQuestion.click();
        Thread.sleep(15000);

        WebElement emailField = driver.findElement(By.id("question_form_email"));

        emailField.click();
        emailField.sendKeys(email);

        WebElement selectSubject = driver.findElement(By.xpath(
                "//div[@class='col-sm-8']//select"
        ));

        selectSubject.click();

        WebElement textMessage = driver.findElement(By.xpath(
                "//textarea[@id='question_form_message']"
        ));

        textMessage.click();
        textMessage.sendKeys(message);

        WebElement clickSubmitButton = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"
        ));

        clickSubmitButton.click();
        Thread.sleep(3000);

        WebElement divHasError = driver.findElement(By.xpath(
                "//div[@class='has-error']//div"
        ));

        String actualResult = divHasError.getText();

        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();

    }

//    @Test
//    public void testUpdateUrl() {
//        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        String url = "https://openweathermap.org/";
//        String expectedResult = "https://openweathermap.org/";
//
//        WebElement clickLogo = driver.findElement("");






//        driver.quit();
//    }

//    @Test
//    public void test() {
//        System.setProperty("webdriver.chrome.driver", "C://Users//ChromeDriver//chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//
//
//
//        driver.quit();
//    }



}
