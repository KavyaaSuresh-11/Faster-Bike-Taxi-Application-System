package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.Builder;
// import velocityventures.mobili.config.JwtUtil;
import velocityventures.mobili.dto.request.LoginRequest;
import velocityventures.mobili.dto.request.RegisterRequest;
import velocityventures.mobili.dto.response.RegisterResponse;
import velocityventures.mobili.entity.User;
import velocityventures.mobili.entity.enums.Role;
import velocityventures.mobili.repository.userRepository;
import velocityventures.mobili.service.UserService;

@Service
public class UserServiceImpl implements UserService {
   private final userRepository userRepo;
   private final PasswordEncoder passwordEncoder;
//    private final JwtUtil jwtUtil;

 public UserServiceImpl(userRepository userRepo, PasswordEncoder passwordEncoder){
    // public UserServiceImpl(userRepository userRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder=passwordEncoder;
        // this.jwtUtil=jwtUtil;
    }


@Override
public RegisterResponse register(RegisterRequest request) {

    System.out.println("Checking email...");
System.out.println(userRepo.existsByEmail(request.getEmail()));
    if (userRepo.existsByEmail(request.getEmail())) {
        throw new RuntimeException("Duplicate Email");
    }

    if (userRepo.existsByUsername(request.getUsername())) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Username already exists"
        );
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
    user.setPhoneNumber(request.getPhoneNumber());
    user.setRole(Role.DRIVER);
    user.setIsActive(true);
    user.setProfileCompleted(false);
    user.setCreatedAt(LocalDateTime.now());
    
    User saveduser = userRepo.save(user);
    RegisterResponse response = RegisterResponse.builder().id(saveduser.getId()).username(saveduser.getUsername())
    .email(saveduser.getEmail()).phoneNumber(saveduser.getPhoneNumber()).build();

    return response;
}
@Override
public List<User> getAllUsers(){
    return userRepo.findAll();
}

@Override
public List<User> getAllDrivers(){
    return userRepo.findByRole(Role.DRIVER);
}

@Override
public User getById(Long id){
    User user = userRepo.findById(id).get();
    return user;
}

@Override 
public User updateUser(Long id, User update){
    User existing = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    existing.setUsername(update.getUsername());
    existing.setEmail(update.getEmail());
    existing.setPasswordHash(passwordEncoder.encode(update.getPasswordHash()));
    existing.setPhoneNumber(update.getPhoneNumber());
    return userRepo.save(existing);
}

@Override
public void deleteUser(Long id){
    if(!userRepo.existsById(id))
    {
        throw new RuntimeException("User not found");
    }
    userRepo.deleteById(id);
}

@Override
public String login(LoginRequest request){
    User user = userRepo.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("User not found!"));
    if(!passwordEncoder.matches(request.getPassword(),user.getPasswordHash())){
        throw new RuntimeException("Invalid password!");
    }
    return "Successful";
    // return jwtUtil.generateToken(user.getEmail());
}
}