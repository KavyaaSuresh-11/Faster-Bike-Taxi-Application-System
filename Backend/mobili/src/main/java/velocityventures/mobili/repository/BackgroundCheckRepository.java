package velocityventures.mobili.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import velocityventures.mobili.entity.BackgroundCheck;

public interface BackgroundCheckRepository extends JpaRepository<BackgroundCheck,Long> {
    Optional<BackgroundCheck> findByDriverApplicationApplicationid(Long applicationid);
}
