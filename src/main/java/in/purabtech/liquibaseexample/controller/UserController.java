package in.purabtech.liquibaseexample.controller;

import in.purabtech.liquibaseexample.model.User;
import in.purabtech.liquibaseexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("users")
    public String createStudent(@RequestParam String name) {
        userRepository.save(new User(name, "Santa Clara University"));
        String nameToReturn = userRepository.findByName(name);
        return userRepository.findByName(name) + " Saved successfully";
    }

    @GetMapping("users")
    public List<User> getAllStudents() {
        return (List<User>) userRepository.findAll();
    }
}


