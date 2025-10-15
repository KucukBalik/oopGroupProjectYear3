package ie.atu.users_service.controller;

import ie.atu.users_service.model.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Users")
@RestController
public class UserController {
    List<User> userList = new ArrayList<>();

    // Post method to create a single user
    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User myUser)
    {
        userList.add(myUser);
        return myUser;
    }

    // Post method to add multiple users
    @PostMapping("/addUsers")
    public List<User> addUsers(@Valid @RequestBody List<User> users){
        userList.addAll(users);
        return userList;
    }

    // Get method to return list of all users
    @GetMapping("/returnAllUsers")
    public List<User> getUserList(){
        return userList;
    }

}
