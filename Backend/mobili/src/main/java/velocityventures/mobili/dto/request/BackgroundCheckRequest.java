package velocityventures.mobili.dto.request;

public class BackgroundCheckRequest {
     private Long applicationId;

    private Boolean policeVerified;

    private Boolean identityVerified;

    private Boolean licenseVerified;

    private Boolean criminalRecordStatus;

    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
}
