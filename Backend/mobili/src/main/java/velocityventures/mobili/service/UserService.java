package velocityventures.mobili.service;

import org.springframework.stereotype.Service;

import velocityventures.mobili.dto.request.RegisterRequest;
import velocityventures.mobili.entity.User;

public interface UserService {
      User register(RegisterRequest request);
}
