package ie.atu.users_service.service;

import ie.atu.users_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList = new ArrayList<>();

    // Defensive Copy of User List -
    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }

    // Search By ID
    public Optional<User> getUserByID(String id){
        for (User user : userList){
            if(user.getUserID().equals(id)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    // Create Multiple Users
    public List<User> createUsers(List<User> userList){
        List<User> addedUsers = new ArrayList<>();
        for(User user : userList){
            if(getUserByID(user.getUserID()).isPresent()){
                throw new IllegalArgumentException("User already exists");
            }
            addedUsers.add(createUser(user));
        }
        return addedUsers;
    }

    // Create One User
    public User createUser(User user){
        if(getUserByID(user.getUserID()).isPresent()){
            throw new IllegalArgumentException("User already exists");
        }
        userList.add(user);
        return user;
    }

    // Update User
    public User update(User user) {
        Optional<User> userFound = getUserByID(user.getUserID());
        if(userFound.isPresent()){
            User updated = userFound.get();
            updated.setPassword(user.getPassword());
            updated.setEmail(user.getEmail());
            return updated;
        }
        throw new IllegalArgumentException("User not found");
    }

    // Delete User
    public User deleteUser(User userFound) {
        if(getUserByID(userFound.getUserID()).isPresent()){
            userList.remove(userFound);
            return userFound;
        }
        throw new IllegalArgumentException("User not found");
    }



}