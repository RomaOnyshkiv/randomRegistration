package utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class ProvideData {

    private static List<User> myUser = new ArrayList<User>();

    public void setData(User user) {
        myUser.add(user);
    }

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][] {
                {myUser.get(0)},
                {myUser.get(1)},
                {myUser.get(2)},
                {myUser.get(3)},
                {myUser.get(4)}
        };
    }

}
