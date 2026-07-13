package velocityventures.mobili.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import velocityventures.mobili.dto.request.LoginRequest;
import velocityventures.mobili.dto.request.RegisterRequest;
import velocityventures.mobili.dto.response.RegisterResponse;
import velocityventures.mobili.entity.User;
import velocityventures.mobili.service.UserService;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "User registered successfully"),
        @ApiResponse(responseCode = "409", description = "Email or username already exists")
    })
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/allusers")
    @Operation(summary = "Get all users")
    @ApiResponse(responseCode = "200", description = "List of all users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list =  userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/alldrivers")
    @Operation(summary = "Get all drivers")
    @ApiResponse(responseCode = "200", description = "List of all drivers")
    public ResponseEntity<List<User>> getAllDrivers(){
        List<User> lst = userService.getAllDrivers();
        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User updated successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User deleted successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User delete successfully";
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Login successful"),
        @ApiResponse(responseCode = "400", description = "Invalid credentials")
    })
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }
}