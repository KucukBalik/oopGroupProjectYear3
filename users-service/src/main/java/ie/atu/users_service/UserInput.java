package ie.atu.users_service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/User")
    @RestController
    public class UserInput {

        @GetMapping("/hello")
        public String hello()
        {
            return "Hello user";
        }

    }
