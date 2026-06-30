package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import velocityventures.mobili.dto.request.RegisterRequest;
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
public User register(RegisterRequest request) {

    if (userRepo.existsByEmail(request.getEmail())) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Email already exists"
        );
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

    return userRepo.save(user);
}
}