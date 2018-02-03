package utils;

import java.util.*;

public class TestData {

    private Set<User> userSet = new HashSet<User>();


    public Set<User> getUserSet() {
        return userSet;
    }


    public void setUserSet(){

        userSet.add(new User("Jan", "Dam"));
        userSet.add(new User("Chuck", "Norris"));
        userSet.add(new User("Clark", "Cent"));
        userSet.add(new User("John", "Daw"));
        userSet.add(new User("Bat", "Man"));
        userSet.add(new User("Tim", "Los"));
        userSet.add(new User("Dave", "Core"));
        userSet.add(new User("Pay", "Pal"));
        userSet.add(new User("Lazy", "Cat"));
        userSet.add(new User("Jack", "Jones"));

    }


    @Override
    public String toString() {
        return "TestData{" +
                "userSet=" + userSet +
                '}';
    }



}
