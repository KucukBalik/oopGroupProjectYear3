package ie.atu.users_service.service;

import ie.atu.users_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList = new ArrayList<>();

    // Defensive Copy of User List
    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }

    public Optional<User> getUserByID(String id){
        for (User user : userList){
            if(user.getUserID().equals(id)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public User createUser(User user){
        // add find by ID method once added to controller class
        userList.add(user);
        return user;
    }


}
