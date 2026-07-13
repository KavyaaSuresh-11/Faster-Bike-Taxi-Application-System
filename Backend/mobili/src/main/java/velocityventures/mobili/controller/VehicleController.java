package velocityventures.mobili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import velocityventures.mobili.dto.request.VehicleRequest;
import velocityventures.mobili.dto.response.VehicleResponse;
import velocityventures.mobili.service.VehicleService;

@RestController
@Tag(name = "Vehicle Management", description = "APIs for managing vehicles")
public class VehicleController {
 
    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addvehicle")
    @Operation(summary = "Add a new vehicle")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle added successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ResponseEntity<VehicleResponse> addVehicle(@RequestBody VehicleRequest request){
        return ResponseEntity.ok(vehicleService.addVehicles(request));
    }

    @GetMapping("/showvehicles")
    @Operation(summary = "Get all vehicles")
    @ApiResponse(responseCode = "200", description = "List of all vehicles")
    public ResponseEntity<List<VehicleResponse>> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/showvehicles/{id}")
    @Operation(summary = "Get vehicle by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle found"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<VehicleResponse> getById(@PathVariable Long id){
         return ResponseEntity.ok(vehicleService.getById(id));
    }

    @PutMapping("/updatevehicle/{id}")
    @Operation(summary = "Update vehicle by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle updated successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest request){
        return ResponseEntity.ok(vehicleService.updateVehicle(id,request));
    }

    @PutMapping("/vehicle/{id}/activate")
    @Operation(summary = "Activate a vehicle")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle activated"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<String> activateVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.activateVehicle(id));
    }

    @PutMapping("/vehicle/{id}/deactivate")
    @Operation(summary = "Deactivate a vehicle")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle deactivated"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<String> deactivateVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.deactivateVehicle(id));
    }

    @PutMapping("/vehicle/{id}/markUnderMaintenance")
    @Operation(summary = "Mark vehicle under maintenance")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle marked under maintenance"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<String> markUnderMaintenance(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.markUnderMaintenance(id));
    }

    @DeleteMapping("/deletevehicle/{id}")
    @Operation(summary = "Delete a vehicle")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Vehicle deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<String> removeVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.removeVehicle(id));
    }
}
