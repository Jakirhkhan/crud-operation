package com.avatar.user.crud.controller;

import com.avatar.user.crud.entity.User;
import com.avatar.user.crud.repository.UserRepository;
import com.avatar.user.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//@ExceptionHandler(Throwable)
public class UserController {

    @Autowired
    private UserService userService;

    // Read all Users
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    // Read a User using USER-ID
    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        if(user == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Read a User using USER-ID & Last Name
    @GetMapping("/users/{id}/{lastName}")
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable String id, @PathVariable String lastName){
        User user = userService.getUser(id, lastName);
        if(user == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Add a User
    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<?>  addUser(@RequestBody User user) {
        User u =  userService.addUser(user);
        return  new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    // Update a User
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String id) {
        User u = userService.updateUser(id, user);
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    // Delete a User
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
