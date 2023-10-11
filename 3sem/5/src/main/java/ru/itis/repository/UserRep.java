package ru.itis.repository;

import ru.itis.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRep {
    static List<User> userList = new ArrayList<>();

    public static User findUser(String name){

        for(User user : userList){
            if(user.name.equals(name)){
                return user;
            }
        }

        return null;
    }

    public static boolean addUser(String name){

        for(User user : userList){
            if(user.name.equals(name)){
                return false;
            }
        }
        userList.add(new User(name));
        return true;
    }
}
