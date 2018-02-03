package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class RegistrationPage extends BasePage {

    public RegistrationPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private SecureRandom random = new SecureRandom();
    private List <WebElement> elements = new ArrayList<WebElement>();

    private By firstName = By.name("first_name");
    private By lastName = By.name("last_name");
    private By martialStatus = By.xpath("//*[@id='pie_register']/li[2]/div/div/label");
    private By hobby = By.xpath("//*[@id='pie_register']/li[3]/div/div/label");
    private By country = By.xpath("//*[@id='dropdown_7']/option");
    private By dob_month = By.xpath("//*[@id='mm_date_8']/option");
    private By dob_day = By.xpath("//*[@id='dd_date_8']/option");
    private By dob_year = By.xpath("//*[@id='yy_date_8']/option");
    private By phone = By.xpath("//*[contains(.,'Phone Number')]/following-sibling::input");
    private By username = By.name("username");
    private By email = By.name("e_mail");
    private By about = By.id("description");
    private By password = By.name("password");
    private By confirmPassword = By.id("confirm_password_password_2");
    private By submitBtn = By.name("pie_submit");
    private By successRegistration = By.xpath("//p[@class='piereg_message']");

    public RegistrationPage registerUser(String firstName, String lastName, String password) {
        typeText(this.firstName, firstName);
        typeText(this.lastName, lastName);

        clickOn(By.xpath("//input[@value='" + driver.findElements(martialStatus).get(selectionId(martialStatus)).getText().toLowerCase() + "']"));
        clickOn(By.xpath("//input[@value='" + driver.findElements(hobby).get(selectionId(hobby)).getText().toLowerCase() + "']"));
        clickOn(By.xpath("//option[@value='" + driver.findElements(country).get(selectionId(country)).getText() + "']"));
        clickOn(By.xpath("//option[@value='" + driver.findElements(dob_month).get(selectionId(dob_month)).getText() + "']"));
        clickOn(By.xpath("//option[@value='" + driver.findElements(dob_day).get(selectionId(dob_day)).getText() + "']"));
        clickOn(By.xpath("//option[@value='" + driver.findElements(dob_year).get(selectionId(dob_year)).getText() + "']"));
        typeText(phone, generatePhone());
        typeText(username, firstName + lastName + generatePhone());
        typeText(email, firstName + lastName + generatePhone() + "@mail.com");
        typeText(about, "User: '" + firstName + "' '" + lastName + "' " + generatePhone());
        typeText(this.password, password);
        typeText(confirmPassword, password);
        clickOn(submitBtn);
        return this;
    }

    public String registrationStatus() {
        return driver.findElement(successRegistration).getText();
    }

    private int selectionId(By by) {
        return random.nextInt(driver.findElements(by).size());
    }

    private String generatePhone() {
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phone.append(random.nextInt(10));
        }
        return phone.toString();
    }



}
