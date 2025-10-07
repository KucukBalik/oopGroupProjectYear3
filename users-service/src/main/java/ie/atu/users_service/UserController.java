package ie.atu.users_service;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Users")
@RestController
public class UserController {
    List<User> userList = new ArrayList<>();

    // basic hello endpoint to test swagger
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello user";
    }

    // Post method to create a single user
    @PostMapping("/addUser")
    public User addUser(@RequestBody User myUser)
    {
        userList.add(myUser);
        return myUser;
    }

    // Post method to add multiple users
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        userList.addAll(users);
        return userList;
    }

    @GetMapping("/returnAllUsers")
    public List<User> getUserList(){
        return userList;
    }
}
