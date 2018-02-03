import com.github.rkumsher.collection.IterableUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.BaseTest;
import utils.ProvideData;
import utils.TestData;
import utils.User;


import static org.testng.Assert.assertEquals;

public class RegisterUsers extends BaseTest {

    private TestData testData = new TestData();
    private ProvideData provideData = new ProvideData();

    @BeforeSuite
    public void setData() {
        testData.setUserSet();
        User addedUser;

        System.out.println("before");
        System.out.println(testData.getUserSet().size());
        System.out.println(testData.getUserSet().toString());

        for (int i = 0; i < 5; i++) {
            addedUser = IterableUtils.randomFrom(testData.getUserSet());
            provideData.setData(addedUser);
            System.out.println(addedUser.toString());
            testData.getUserSet().remove(addedUser);
        }

    }

    @Test(dataProvider = "users", dataProviderClass = ProvideData.class)
    public void testRegisterUsers(User user) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(BASE_URL);
        assertEquals(BASE_URL, driver.getCurrentUrl());
        assertEquals("Thank you for your registration",
                registrationPage.registerUser(
                        user.getFirstName(), user.getLastName(), "someSecurePassword121!")
                        .registrationStatus());

    }

    @AfterSuite
    public void notRegisteredUsers() {
        System.out.println("after");
        System.out.println(testData.getUserSet().size());
        System.out.println(testData.getUserSet().toString());

    }
}
