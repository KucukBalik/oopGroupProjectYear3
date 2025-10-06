package ie.atu.users_service;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/User")
    @RestController
    public class UserInput {
    List<UserInput> myList = new ArrayList<>();
        @GetMapping("/hello")
        public String hello()
        {
            return "Hello user";
        }

    @PostMapping("/addUser")
        public UserInput addUser(@RequestBody UserInput myUser)
        {
        myList.add(myUser);
        return myUser;
        }
    }
