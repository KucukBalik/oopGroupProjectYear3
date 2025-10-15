package ie.atu.users_service.controller;

import ie.atu.users_service.model.User;
import ie.atu.users_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/user")
@RestController
public class UserController {

    // Constructor Based Dependency Injection
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get Request to Return List of all Users
    @GetMapping("/returnAllUsers")
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok(userService.getUserList());
    }

    // Get Request to find by ID Search
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        Optional<User> userFound = userService.getUserByID(id);
        if(userFound.isPresent()){
            return ResponseEntity.ok(userFound.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    // Post method to create a single user
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User userCreated = userService.createUser(user);
        return ResponseEntity
                .created(URI.create("/api/user" + userCreated.getUserID()))
                .body(userCreated);
    }

    // Post method to add multiple users
    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> addUsers(@Valid @RequestBody List<User> users){
        List<User> addedUsers = userService.createUsers(users);
        return ResponseEntity
                .created(URI.create("/api/users"))
                .body(addedUsers);
    }

}