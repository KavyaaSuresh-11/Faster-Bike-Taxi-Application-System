package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import velocityventures.mobili.dto.request.VehicleRequest;
import velocityventures.mobili.dto.response.VehicleResponse;
import velocityventures.mobili.entity.Vehicle;
import velocityventures.mobili.entity.enums.VehicleConditions;
import velocityventures.mobili.entity.enums.VehicleStatus;
import velocityventures.mobili.repository.VehicleRepository;
import velocityventures.mobili.service.VehicleService;

@Service
public class VehicleImpl implements VehicleService{
    

    @Autowired
    private VehicleRepository vehicleRepo;

    @Override
    public VehicleResponse addVehicles(VehicleRequest request){
        Vehicle vehicle = Vehicle.builder()
        .vehicleType(request.getVehicleType())
        .registrationNumber(request.getRegistrationNumber())
        .brand(request.getBrand())
        .model(request.getModel()).pollutionExpiry(request.getPollutionExpiry())
        .color(request.getColor()).pollutionCertificateNumber(request.getPollutionCertificateNumber())
        .manufactureYear(request.getManufactureYear()).insuranceExpiry(request.getInsuranceExpiry())
        .insurancePolicyNumber(request.getInsurancePolicyNumber())
        .vehicleConditions(VehicleConditions.GOOD)
        .vehicleStatus(VehicleStatus.INACTIVE)
        .createdAt(LocalDateTime.now())
        .build();

        Vehicle saved = vehicleRepo.save(vehicle);

        return VehicleResponse.builder()
        .id(saved.getId())
        .registrationNumber(saved.getRegistrationNumber())
        .vehicleCondition(saved.getVehicleConditions())
        .vehicleStatus(saved.getVehicleStatus())
        .createdAt(saved.getCreatedAt()).build();
    }

    @Override
    public List<VehicleResponse> getAllVehicles(){

        List<Vehicle> overall_list = vehicleRepo.findAll();
        List<VehicleResponse> list = new ArrayList<>();
        for(Vehicle vehicle : overall_list){
            VehicleResponse response = VehicleResponse.builder()
            .id(vehicle.getId())
            .registrationNumber(vehicle.getRegistrationNumber())
            .vehicleCondition(vehicle.getVehicleConditions())
            .vehicleStatus(vehicle.getVehicleStatus())
            .createdAt(vehicle.getCreatedAt()).build();

            list.add(response);
        }
        return list;
    }

    @Override
    public VehicleResponse getById(Long id){
        Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(()-> new RuntimeException("Vehicle not found!"));
        VehicleResponse response = VehicleResponse.builder()
        .id(vehicle.getId())
        .registrationNumber(vehicle.getRegistrationNumber())
        .vehicleCondition(vehicle.getVehicleConditions())
        .vehicleStatus(vehicle.getVehicleStatus())
        .createdAt(vehicle.getCreatedAt()).build();
        return response;
    }

    @Override
public VehicleResponse updateVehicle(Long id, VehicleRequest request) {

    Vehicle vehicle = vehicleRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehicle not found"));

    vehicle.setVehicleType(request.getVehicleType());
    vehicle.setRegistrationNumber(request.getRegistrationNumber());
    vehicle.setBrand(request.getBrand());
    vehicle.setModel(request.getModel());
    vehicle.setColor(request.getColor());
    vehicle.setManufactureYear(request.getManufactureYear());
    vehicle.setInsurancePolicyNumber(request.getInsurancePolicyNumber());
    vehicle.setInsuranceExpiry(request.getInsuranceExpiry());
    vehicle.setPollutionCertificateNumber(request.getPollutionCertificateNumber());
    vehicle.setPollutionCertificateExpiry(request.getPollutionExpiry());

    Vehicle saved = vehicleRepo.save(vehicle);

    return VehicleResponse.builder()
            .id(saved.getId())
            .registrationNumber(saved.getRegistrationNumber())
            .vehicleCondition(saved.getVehicleConditions())
            .vehicleStatus(saved.getVehicleStatus())
            .createdAt(saved.getCreatedAt())
            .build();
}

@Override
public String removeVehicle(Long id) {

    Vehicle vehicle = vehicleRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehicle not found"));

    vehicleRepo.delete(vehicle);

    return "Vehicle deleted successfully!";
}

@Override
public String activateVehicle(Long id){
    Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(()-> new RuntimeException("Vehicle not found!"));
    vehicle.setVehicleStatus(VehicleStatus.ACTIVE);
    vehicleRepo.save(vehicle);
    return "Vehicle active to ride";
}

@Override
public String deactivateVehicle(Long id){
    Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(()-> new RuntimeException("Vehicle not found!"));
    vehicle.setVehicleStatus(VehicleStatus.INACTIVE);
    vehicleRepo.save(vehicle);
    return "Vehicle deactivated";
}

@Override
public String markUnderMaintenance(Long id){
    Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(()-> new RuntimeException("Vehicle not found!"));
    vehicle.setVehicleStatus(VehicleStatus.UNDER_MAINTENANCE);
    vehicleRepo.save(vehicle);
    return "Vehicle marked Undermaintenance";
}

}
