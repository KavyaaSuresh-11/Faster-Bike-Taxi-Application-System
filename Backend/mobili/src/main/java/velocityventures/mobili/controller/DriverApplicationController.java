package velocityventures.mobili.controller;

import java.sql.Driver;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import velocityventures.mobili.dto.request.ApplicationRequest;
import velocityventures.mobili.dto.response.ApplicationResponse;
import velocityventures.mobili.service.ApplicationService;

@RestController
public class DriverApplicationController {
    
    private ApplicationService applicationService;

    public DriverApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }

    @PostMapping("/create-application")
    public ResponseEntity<ApplicationResponse> createApplication(@RequestBody ApplicationRequest request){
        // ApplicationResponse response = applicationService.createApplication(request);
        // return response;

        return ResponseEntity.ok(applicationService.createApplication(request));
    }

    @GetMapping("/get-all-applications")
    public ResponseEntity<List<ApplicationResponse>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }
    
    @GetMapping("/get-applications/{id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @PutMapping("/putapp/{id}")
    public ResponseEntity<ApplicationResponse> updateById(@PathVariable Long id, @RequestBody ApplicationRequest request){
        return ResponseEntity.ok(applicationService.updateById(id,request));
    }

    @PutMapping("/putapp/{id}/approve")
    public ResponseEntity<String> approveApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.approveApplication(id));
    }

     @PutMapping("/putapp/{id}/reject")
    public ResponseEntity<String> rejectApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.rejectApplication(id));
    }

     @PutMapping("/putapp/{id}/withhold")
    public ResponseEntity<String> withholdApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.withholdApplication(id));
    }

    @DeleteMapping("/delete-application/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.deleteById(id));
    }
}
