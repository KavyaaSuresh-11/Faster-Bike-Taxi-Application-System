package velocityventures.mobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import velocityventures.mobili.entity.Document;

public interface DocumentRepository extends JpaRepository<Document,Long> {
    
}
