package velocityventures.mobili.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import velocityventures.mobili.entity.User;
public interface userRepository extends JpaRepository<User,Long> {

boolean existsByEmail(String email);

boolean existsByUsername(String username);

List<User> findAll();

List<User> findByRole(velocityventures.mobili.entity.enums.Role role);

Optional<User> findById(Long id);
Optional<User> findByEmail(String email);
}