package velocityventures.mobili.controller;

import java.util.List;

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
import velocityventures.mobili.dto.request.ApplicationRequest;
import velocityventures.mobili.dto.response.ApplicationResponse;
import velocityventures.mobili.service.ApplicationService;

@RestController
@Tag(name = "Driver Application", description = "APIs for managing driver applications")
public class DriverApplicationController {
    
    private ApplicationService applicationService;

    public DriverApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }

    @PostMapping("/create-application")
    @Operation(summary = "Create a new driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application created successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<ApplicationResponse> createApplication(@RequestBody ApplicationRequest request){
        // ApplicationResponse response = applicationService.createApplication(request);
        // return response;

        return ResponseEntity.ok(applicationService.createApplication(request));
    }

    @GetMapping("/get-all-applications")
    @Operation(summary = "Get all driver applications")
    @ApiResponse(responseCode = "200", description = "List of all applications")
    public ResponseEntity<List<ApplicationResponse>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }
    
    @GetMapping("/get-applications/{id}")
    @Operation(summary = "Get driver application by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application found"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @PutMapping("/putapp/{id}")
    @Operation(summary = "Update driver application by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application updated successfully"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<ApplicationResponse> updateById(@PathVariable Long id, @RequestBody ApplicationRequest request){
        return ResponseEntity.ok(applicationService.updateById(id,request));
    }

    @PutMapping("/putapp/{id}/approve")
    @Operation(summary = "Approve a driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application approved"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<String> approveApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.approveApplication(id));
    }

    @PutMapping("/putapp/{id}/reject")
    @Operation(summary = "Reject a driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application rejected"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<String> rejectApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.rejectApplication(id));
    }

    @PutMapping("/putapp/{id}/withhold")
    @Operation(summary = "Withhold a driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application withheld"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<String> withholdApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.withholdApplication(id));
    }

    @DeleteMapping("/delete-application/{id}")
    @Operation(summary = "Delete a driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Application deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.deleteById(id));
    }
}
