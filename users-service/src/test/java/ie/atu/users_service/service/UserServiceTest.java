package ie.atu.users_service.service;

import ie.atu.users_service.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class  UserServiceTest {
   /*
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

        userService.create(user);
        assertEquals("U1", user.getUserID());
        assertEquals("pat@atu.ie", user.getEmail());


    }

    @Test
    void duplicatedThrows() {
        userService.create(User.builder()
                .userID("U2")
                .email("rob@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                userService.create(User.builder()
                        .userID("U2")
                        .email("rob@ex.ie")
                        .build()));
    }

    @Test
    void updateUserSuccess(){
        User oldUser = User.builder()
                .userID("U001")
                .email("meike@gmail.com")
                .password("suprsecure")
                .build();
        userService.create(oldUser);

        User newUser = User.builder()
                .userID("U001")
                .email("notMeike@gmail.com")
                .password("1234")
                .build();
        User updating = userService.update(newUser);
        assertEquals(newUser.getEmail(), updating.getEmail());
    }

    @Test
    void deleteUserSuccess(){
        User oldUser = User.builder()
                .userID("U001")
                .email("meike@gmail.com")
                .password("suprsecure")
                .build();
        userService.create(oldUser);
        userService.deleteUser(oldUser.getUserID());
        Optional<User> found = userService.getUserById(oldUser.getUserID());
        assertTrue(found.isEmpty());
    }

    */
}