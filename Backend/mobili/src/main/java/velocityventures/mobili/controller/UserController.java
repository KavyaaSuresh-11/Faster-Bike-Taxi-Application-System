package velocityventures.mobili.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import velocityventures.mobili.dto.request.LoginRequest;
import velocityventures.mobili.dto.request.RegisterRequest;
import velocityventures.mobili.dto.response.RegisterResponse;
import velocityventures.mobili.entity.User;
import velocityventures.mobili.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list =  userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/alldrivers")
    public ResponseEntity<List<User>> getAllDrivers(){
        List<User> lst = userService.getAllDrivers();
        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User delete successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }
}