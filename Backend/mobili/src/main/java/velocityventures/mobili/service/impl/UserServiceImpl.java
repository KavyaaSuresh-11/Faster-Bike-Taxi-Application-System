package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

   public UserServiceImpl(userRepository userRepo) {
        this.userRepo = userRepo;
    }


@Override
public RegisterResponse register(RegisterRequest request) {

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
    user.setPasswordHash(request.getPassword());
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
    User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    return user;
}

@Override 
public User updateUser(Long id, User update){
    User existing = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    existing.setUsername(update.getUsername());
    existing.setEmail(update.getEmail());
    existing.setPasswordHash(update.getPasswordHash());
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
}@Override
public String login(LoginRequest request) {

    System.out.println("Request Email: '" + request.getEmail() + "'");

    Optional<User> optionalUser = userRepo.findByEmail(request.getEmail());

    System.out.println("User Found: " + optionalUser.isPresent());

    User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found!"));

    System.out.println("DB Email: " + user.getEmail());

    if (!user.getPasswordHash().equals(request.getPassword())) {
        throw new RuntimeException("Invalid password!");
    }

    return "Login Successful";
}
}