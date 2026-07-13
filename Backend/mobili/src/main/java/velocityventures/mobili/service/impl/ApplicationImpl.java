package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import velocityventures.mobili.dto.request.ApplicationRequest;
import velocityventures.mobili.dto.response.ApplicationResponse;
import velocityventures.mobili.entity.DriverApplication;
import velocityventures.mobili.entity.User;
import velocityventures.mobili.entity.enums.ApplicationStatus;
import velocityventures.mobili.repository.DriverApplicationRepository;
import velocityventures.mobili.repository.userRepository;
import velocityventures.mobili.service.ApplicationService;
import velocityventures.mobili.service.NotificationService;
import velocityventures.mobili.dto.request.NotificationRequest;
import velocityventures.mobili.entity.enums.NotificationType;

@Service
public class ApplicationImpl implements ApplicationService {
    
    private DriverApplicationRepository appRepo;
    private userRepository userRepo;
    private final NotificationService notificationService;

    public ApplicationImpl(DriverApplicationRepository appRepo, userRepository userRepo,
            NotificationService notificationService) {
        this.appRepo = appRepo;
        this.userRepo = userRepo;
        this.notificationService = notificationService;
    }

@Override
public ApplicationResponse createApplication(ApplicationRequest request) {

   User user = userRepo.findById(request.getUser_id()).orElseThrow(()-> new RuntimeException("No user found"));
   DriverApplication application = DriverApplication.builder()
   .user(user)
   .remarks(request.getRemarks())
   .status(ApplicationStatus.UNDER_REVIEW)
   .submitted_at(LocalDateTime.now())
   .updated_at(LocalDateTime.now()).build();

   DriverApplication saved = appRepo.save(application);

   return ApplicationResponse.builder()
   .remarks(saved.getRemarks())
   .userId(saved.getUser().getId())
   .applicationId(saved.getApplicationId())
   .status(saved.getStatus())
   .submittedAt(saved.getSubmitted_at())
        .updatedAt(saved.getUpdated_at()).build();
}

@Override
public List<ApplicationResponse> getAllApplications(){
    List<DriverApplication> overall_list = appRepo.findAll();

    List<ApplicationResponse> list = new ArrayList<>();
    for(DriverApplication dr : overall_list){
        ApplicationResponse response =  ApplicationResponse.builder().applicationId(dr.getApplicationId())
        .userId(dr.getUser().getId())
        .remarks(dr.getRemarks())
        .status(dr.getStatus())
        .submittedAt(dr.getSubmitted_at())
        .updatedAt(dr.getUpdated_at()).build();

        list.add(response);
    }
    return list;
}

@Override
public ApplicationResponse getApplicationById(Long id){
    DriverApplication app = appRepo.findById(id).orElseThrow(()->new RuntimeException("No Application found"));
    ApplicationResponse response = ApplicationResponse.builder()
    .applicationId(app.getApplicationId())
    .userId(app.getUser().getId())
    .remarks(app.getRemarks())
    .status(app.getStatus())
    .submittedAt(app.getSubmitted_at())
    .updatedAt(app.getUpdated_at()).build();
    return response;
}

@Override
public ApplicationResponse updateById(Long id, ApplicationRequest request){
    DriverApplication application = appRepo.findById(id).orElseThrow(()-> new RuntimeException("No application found"));
    application.setRemarks(request.getRemarks());
    application.setUpdated_at(LocalDateTime.now());
    DriverApplication saved = appRepo.save(application);

    ApplicationResponse response = ApplicationResponse.builder()
    .remarks(saved.getRemarks())
    .applicationId(saved.getApplicationId())
    .status(saved.getStatus())
    .submittedAt(saved.getSubmitted_at())
    .updatedAt(saved.getUpdated_at())
    .userId(saved.getUser().getId()).build();

    return response;

}

@Override
public String deleteById(Long id){
    DriverApplication app = appRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid data"));
    appRepo.delete(app);
    return "Successfully deleted!";
}

@Override
public String approveApplication(Long id){
    DriverApplication application = appRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid data"));
    application.setStatus(ApplicationStatus.APPROVED);
    appRepo.save(application);
    notificationService.sendNotification(NotificationRequest.builder()
            .applicationId(application.getApplicationId())
            .title("Application Approved")
            .message("Congratulations! Your driver application has been approved.")
            .notificationType(NotificationType.APPLICATION)
            .build());
    return "Application approved!";
}


@Override
public String rejectApplication(Long id){
    DriverApplication application = appRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid data"));
    application.setStatus(ApplicationStatus.REJECTED);
    appRepo.save(application);
    notificationService.sendNotification(NotificationRequest.builder()
            .applicationId(application.getApplicationId())
            .title("Application Rejected")
            .message("Your driver application has been rejected.")
            .notificationType(NotificationType.APPLICATION)
            .build());
    return "Application rejected!";
}


@Override
public String withholdApplication(Long id){
    DriverApplication application = appRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid data"));
    application.setStatus(ApplicationStatus.ON_HOLD);
    appRepo.save(application);
    return "Application withhold!";
}
}