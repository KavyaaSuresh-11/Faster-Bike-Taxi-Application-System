package velocityventures.mobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import velocityventures.mobili.entity.User;

public interface userRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

boolean existsByUsername(String username);
}
