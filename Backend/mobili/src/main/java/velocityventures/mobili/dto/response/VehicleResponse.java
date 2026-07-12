package velocityventures.mobili.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import velocityventures.mobili.entity.enums.VehicleConditions;
import velocityventures.mobili.entity.enums.VehicleStatus;

@Builder
public class VehicleResponse {
    
    private Long id;
    private String registrationNumber;
    private VehicleConditions vehicleCondition;
    private VehicleStatus vehicleStatus;
    private LocalDateTime createdAt;

    public VehicleResponse(){

    }
    

    public VehicleResponse(Long id, String registrationNumber, VehicleConditions vehicleCondition,
            VehicleStatus vehicleStatus, LocalDateTime createdAt) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.vehicleCondition = vehicleCondition;
        this.vehicleStatus = vehicleStatus;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleConditions getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(VehicleConditions vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}