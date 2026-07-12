package velocityventures.mobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import velocityventures.mobili.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    
}
