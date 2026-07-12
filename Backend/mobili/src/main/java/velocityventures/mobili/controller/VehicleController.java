package velocityventures.mobili.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import velocityventures.mobili.dto.request.VehicleRequest;
import velocityventures.mobili.dto.response.VehicleResponse;
import velocityventures.mobili.service.VehicleService;

@RestController
public class VehicleController {
 
    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addvehicle")
    public ResponseEntity<VehicleResponse> addVehicle(@RequestBody VehicleRequest request){
        return ResponseEntity.ok(vehicleService.addVehicles(request));
    }

    @GetMapping("/showvehicles")
    public ResponseEntity<List<VehicleResponse>> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/showvehicles/{id}")
    public ResponseEntity<VehicleResponse> getById(@PathVariable Long id){
         return ResponseEntity.ok(vehicleService.getById(id));
    }

    @PutMapping("/updatevehicle/{id}")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest request){
        return ResponseEntity.ok(vehicleService.updateVehicle(id,request));
    }

    @PutMapping("/vehicle/{id}/activate")
    public ResponseEntity<String> activateVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.activateVehicle(id));
    }

    @PutMapping("vehicle/{id}/deactivate")
    public ResponseEntity<String> deactivateVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.deactivateVehicle(id));
    }

    @PutMapping("vehicle/{id}/markUnderMaintenance")
    public ResponseEntity<String> markUnderMaintenance(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.markUnderMaintenance(id));
    }

    @DeleteMapping("/deletevehicle/{id}")
     public ResponseEntity<String> removeVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.removeVehicle(id));
    }
}
