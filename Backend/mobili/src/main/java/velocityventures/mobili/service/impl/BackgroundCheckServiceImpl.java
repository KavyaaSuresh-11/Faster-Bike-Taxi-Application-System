package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import velocityventures.mobili.dto.request.BackgroundCheckRequest;
import velocityventures.mobili.dto.request.NotificationRequest;
import velocityventures.mobili.dto.response.BackgroundCheckResponse;
import velocityventures.mobili.entity.BackgroundCheck;
import velocityventures.mobili.entity.DriverApplication;
import velocityventures.mobili.entity.enums.ApplicationStatus;
import velocityventures.mobili.entity.enums.NotificationType;
import velocityventures.mobili.entity.enums.VerificationStatus;
import velocityventures.mobili.repository.BackgroundCheckRepository;
import velocityventures.mobili.repository.DriverApplicationRepository;
import velocityventures.mobili.service.BackgroundCheckService;
import velocityventures.mobili.service.NotificationService;

@Service
public class BackgroundCheckServiceImpl implements BackgroundCheckService {
    
    @Autowired 
    private BackgroundCheckRepository backgroundCheckRepository;

    @Autowired
    private DriverApplicationRepository driverApplicationRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public BackgroundCheckResponse performBackgroundCheck(BackgroundCheckRequest request){
        DriverApplication application = driverApplicationRepository.findById(request.getApplicationId()).orElseThrow(()-> new RuntimeException("Application not found!"));

        if (backgroundCheckRepository
                .findByDriverApplicationApplicationid(request.getApplicationId())
                .isPresent()) {
            throw new RuntimeException("Background check already exists for this application.");
        }
        BackgroundCheck backgroundCheck = new BackgroundCheck();
        backgroundCheck.setDriverApplication(application);
        backgroundCheck.setPoliceVerified(request.getPoliceVerified());
        backgroundCheck.setIdentityVerified(request.getIdentityVerified());
        backgroundCheck.setLicenseVerified(request.getLicenseVerified());
        backgroundCheck.setCriminalRecordStatus(request.getCriminalRecordStatus());
        backgroundCheck.setRemarks(request.getRemarks());
        backgroundCheck.setVerificationDate(LocalDateTime.now());

         boolean passed =
                Boolean.TRUE.equals(request.getPoliceVerified()) &&
                Boolean.TRUE.equals(request.getIdentityVerified()) &&
                Boolean.TRUE.equals(request.getLicenseVerified()) &&
                Boolean.FALSE.equals(request.getCriminalRecordStatus());
                
                 if (passed) {
            backgroundCheck.setVerificationStatus(VerificationStatus.APPROVED);
        } else {
            backgroundCheck.setVerificationStatus(VerificationStatus.REJECTED);
        }

        BackgroundCheck saved = backgroundCheckRepository.save(backgroundCheck);

        String title = passed ? "Background Check Approved" : "Background Check Rejected";
        String message = passed
                ? "Your background verification has been completed successfully."
                : "Your background verification has failed.";
        notificationService.sendNotification(NotificationRequest.builder()
                .applicationId(application.getApplicationId())
                .title(title)
                .message(message)
                .notificationType(NotificationType.BACKGROUND_CHECK)
                .build());

        return  BackgroundCheckResponse.builder()
        .applicationId(saved.getDriverApplication().getApplicationId())
        .backgroundCheckId(saved.getBackgroundCheckId())
        .criminalRecordStatus(saved.getCriminalRecordStatus())
        .identityVerified(saved.getIdentityVerified())
        .policeVerified(saved.getPoliceVerified())
        .licenseVerified(saved.getLicenseVerified())
        .verificationStatus(saved.getVerificationStatus())
        .verificationDate(saved.getVerificationDate())
        .remarks(saved.getRemarks()).build();
    }

    @Override
public List<BackgroundCheckResponse> getAll() {

    List<BackgroundCheck> overall = backgroundCheckRepository.findAll();
    List<BackgroundCheckResponse> list = new ArrayList<>();

    for (BackgroundCheck backgroundCheck : overall) {

        BackgroundCheckResponse response = BackgroundCheckResponse.builder()
                .backgroundCheckId(backgroundCheck.getBackgroundCheckId())
                .applicationId(backgroundCheck.getDriverApplication().getApplicationId())
                .policeVerified(backgroundCheck.getPoliceVerified())
                .identityVerified(backgroundCheck.getIdentityVerified())
                .licenseVerified(backgroundCheck.getLicenseVerified())
                .criminalRecordStatus(backgroundCheck.getCriminalRecordStatus())
                .verificationStatus(backgroundCheck.getVerificationStatus())
                .verificationDate(backgroundCheck.getVerificationDate())
                .remarks(backgroundCheck.getRemarks())
                .build();

        list.add(response);
    }

    return list;
}

@Override
public BackgroundCheckResponse getById(Long id) {

    BackgroundCheck backgroundCheck = backgroundCheckRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Background Check not found!"));

    return BackgroundCheckResponse.builder()
            .backgroundCheckId(backgroundCheck.getBackgroundCheckId())
            .applicationId(backgroundCheck.getDriverApplication().getApplicationId())
            .policeVerified(backgroundCheck.getPoliceVerified())
            .identityVerified(backgroundCheck.getIdentityVerified())
            .licenseVerified(backgroundCheck.getLicenseVerified())
            .criminalRecordStatus(backgroundCheck.getCriminalRecordStatus())
            .verificationStatus(backgroundCheck.getVerificationStatus())
            .verificationDate(backgroundCheck.getVerificationDate())
            .remarks(backgroundCheck.getRemarks())
            .build();
} 

@Override
public BackgroundCheckResponse getByApplicationId(Long applicationId) {

    BackgroundCheck backgroundCheck = backgroundCheckRepository
            .findByDriverApplicationApplicationid(applicationId)
            .orElseThrow(() -> new RuntimeException("Background Check not found!"));

    return BackgroundCheckResponse.builder()
            .backgroundCheckId(backgroundCheck.getBackgroundCheckId())
            .applicationId(backgroundCheck.getDriverApplication().getApplicationId())
            .policeVerified(backgroundCheck.getPoliceVerified())
            .identityVerified(backgroundCheck.getIdentityVerified())
            .licenseVerified(backgroundCheck.getLicenseVerified())
            .criminalRecordStatus(backgroundCheck.getCriminalRecordStatus())
            .verificationStatus(backgroundCheck.getVerificationStatus())
            .verificationDate(backgroundCheck.getVerificationDate())
            .remarks(backgroundCheck.getRemarks())
            .build();
}
}

