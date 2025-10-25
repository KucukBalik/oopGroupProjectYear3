package ie.atu.users_service.service;

import ie.atu.users_service.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setup() {userService = new UserService();
    }

    @Test
    void createThenFindById() {
        User user = User.builder()
                .userID("U1")
                .email("pat@atu.ie")
                .password("password")
                .build();

        userService.createUser(user);

        Optional<User> found = userService.getUserByID("U1");
        assertTrue(found.isPresent());
        assertEquals("pat@atu.ie", found.get().getEmail());


    }

    @Test
    void duplicatedThrows() {
        userService.createUser(User.builder()
                .userID("U2")
                .email("rob@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(User.builder()
                        .userID("U2")
                        .email("rob@ex.ie")
                        .build()));
    }
}
