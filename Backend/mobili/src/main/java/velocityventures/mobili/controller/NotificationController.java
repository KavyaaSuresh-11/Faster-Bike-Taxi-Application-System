package velocityventures.mobili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import velocityventures.mobili.dto.request.NotificationRequest;
import velocityventures.mobili.dto.response.NotificationResponse;
import velocityventures.mobili.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@Tag(name = "Notification", description = "APIs for managing notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    @Operation(summary = "Send a notification")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Notification sent"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<NotificationResponse> sendNotification(
            @RequestBody NotificationRequest request) {

        return new ResponseEntity<>(
                notificationService.sendNotification(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all notifications")
    @ApiResponse(responseCode = "200", description = "List of all notifications")
    public ResponseEntity<List<NotificationResponse>> getAll() {

        return new ResponseEntity<>(
                notificationService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get notification by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Notification found"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<NotificationResponse> getById(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                notificationService.getById(id),
                HttpStatus.OK);
    }

    @GetMapping("/application/{applicationId}")
    @Operation(summary = "Get notifications by application ID")
    @ApiResponse(responseCode = "200", description = "List of notifications for the application")
    public ResponseEntity<List<NotificationResponse>> getByApplicationId(
            @PathVariable Long applicationId) {

        return new ResponseEntity<>(
                notificationService.getByApplicationId(applicationId),
                HttpStatus.OK);
    }

    @PutMapping("/read/{id}")
    @Operation(summary = "Mark notification as read")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Marked as read"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<String> markAsRead(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                notificationService.markAsRead(id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a notification")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Notification deleted"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<String> deleteById(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                notificationService.deleteById(id),
                HttpStatus.OK);
    }
}