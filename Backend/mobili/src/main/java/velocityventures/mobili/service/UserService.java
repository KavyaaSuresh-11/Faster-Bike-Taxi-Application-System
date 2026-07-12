package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.LoginRequest;
import velocityventures.mobili.dto.request.RegisterRequest;
import velocityventures.mobili.dto.response.RegisterResponse;
import velocityventures.mobili.entity.User;

public interface UserService {
      RegisterResponse register(RegisterRequest request);
      List<User> getAllUsers();
      List<User> getAllDrivers();
      User getById(Long id);
      User updateUser(Long id, User update);
      void deleteUser(Long id);
      String login(LoginRequest request);
}
