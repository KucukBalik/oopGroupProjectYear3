package ie.atu.users_service;

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

    /*
    TODO
    - add @PutMapping for updating users
    - add @DeleteMapping to delete users
    - Add crud tests (basic validation using @Valid and other annotations
    - add lombok to reduce redundancy
    - add ID for users, we can simply initialize id to 1, set user ID and then increment ID so there is no dupes
    -> slight error with this, as @RequestBody will ask for all fields set in user
       (email, passwd, ID) but wont assign a new id as we handle that separately. not ideal but works
     */
}
