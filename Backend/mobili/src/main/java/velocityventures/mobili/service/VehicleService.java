package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.VehicleRequest;
import velocityventures.mobili.dto.response.VehicleResponse;

public interface VehicleService {
    
    VehicleResponse addVehicles(VehicleRequest request);
    List<VehicleResponse> getAllVehicles();
    VehicleResponse getById(Long id);
    VehicleResponse updateVehicle(Long id, VehicleRequest request);
    String removeVehicle(Long id);
    String activateVehicle(Long id);
    String deactivateVehicle(Long id);
    String markUnderMaintenance(Long id);
}
