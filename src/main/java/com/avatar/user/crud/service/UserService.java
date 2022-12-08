package com.avatar.user.crud.service;

import com.avatar.user.crud.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private User user;

    // Dummy or Static data
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("1000","Jakir Hosen ","Khan"),
            new User("1001","Nazmul ","Islam"),
            new User("1002","M. Rasel ","Parvej"),
            new User("1003","Md. Omar  ","Faruq"),
            new User("1004","Md. Aminur ","Rahman")
    ));


    public List<User> allUsers(){
        return users;
    }

    public User getUser(String id){
        User user = users.stream()
                .filter(u-> u.getId().equals(id))
                .findFirst().get();
        return user;
    }

    public User getUser(String id, String lastName){
        User user = users.stream()
                .filter(u-> u.getId().equals(id))
                .filter(u->u.getLastName().equals(lastName))
                .findFirst().get();
        //System.out.println(user);
        return user;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public User updateUser(String id, User user){
        for(int i=0; i < users.size(); i++){
            User u = users.get(i);

            if(u.getId().equals(id)){
                users.set(i, user);
                return users.get(i);
            }
        }
        return null;
    }

    public void deleteUser(String id){
        users.removeIf(u -> u.getId().equals(id));
    }
}
