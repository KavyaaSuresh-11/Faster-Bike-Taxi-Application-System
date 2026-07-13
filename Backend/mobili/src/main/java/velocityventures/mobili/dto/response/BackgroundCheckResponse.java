package velocityventures.mobili.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import velocityventures.mobili.entity.enums.VerificationStatus;

@Builder
public class BackgroundCheckResponse {
     private Long backgroundCheckId;

    private Long applicationId;

    private Boolean policeVerified;

    private Boolean identityVerified;

    private Boolean licenseVerified;

    private Boolean criminalRecordStatus;

    private VerificationStatus verificationStatus;

    private LocalDateTime verificationDate;

    private String remarks;

    public Long getBackgroundCheckId() {
        return backgroundCheckId;
    }

    public void setBackgroundCheckId(Long backgroundCheckId) {
        this.backgroundCheckId = backgroundCheckId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Boolean getPoliceVerified() {
        return policeVerified;
    }

    public void setPoliceVerified(Boolean policeVerified) {
        this.policeVerified = policeVerified;
    }

    public Boolean getIdentityVerified() {
        return identityVerified;
    }

    public void setIdentityVerified(Boolean identityVerified) {
        this.identityVerified = identityVerified;
    }

    public Boolean getLicenseVerified() {
        return licenseVerified;
    }

    public void setLicenseVerified(Boolean licenseVerified) {
        this.licenseVerified = licenseVerified;
    }

    public Boolean getCriminalRecordStatus() {
        return criminalRecordStatus;
    }

    public void setCriminalRecordStatus(Boolean criminalRecordStatus) {
        this.criminalRecordStatus = criminalRecordStatus;
    }

    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public LocalDateTime getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDateTime verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
}
