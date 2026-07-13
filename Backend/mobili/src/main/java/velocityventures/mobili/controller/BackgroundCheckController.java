package velocityventures.mobili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import velocityventures.mobili.dto.request.BackgroundCheckRequest;
import velocityventures.mobili.dto.response.BackgroundCheckResponse;
import velocityventures.mobili.service.BackgroundCheckService;

@RestController
@RequestMapping("/background-check")
@Tag(name = "Background Check", description = "APIs for performing and retrieving background checks")
public class BackgroundCheckController {
     @Autowired
    private BackgroundCheckService backgroundCheckService;

    @PostMapping("/perform")
    @Operation(summary = "Perform a background check for a driver application")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Background check performed"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<BackgroundCheckResponse> performBackgroundCheck(
            @RequestBody BackgroundCheckRequest request) {

        return new ResponseEntity<>(
                backgroundCheckService.performBackgroundCheck(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all background checks")
    @ApiResponse(responseCode = "200", description = "List of all background checks")
    public ResponseEntity<List<BackgroundCheckResponse>> getAll() {

        return new ResponseEntity<>(
                backgroundCheckService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Get background check by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Background check found"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<BackgroundCheckResponse> getById(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                backgroundCheckService.getById(id),
                HttpStatus.OK);
    }

    @GetMapping("/application/{applicationId}")
    @Operation(summary = "Get background check by application ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Background check found"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<BackgroundCheckResponse> getByApplicationId(
            @PathVariable Long applicationId) {

        return new ResponseEntity<>(
                backgroundCheckService.getByApplicationId(applicationId),
                HttpStatus.OK);
    }
}
