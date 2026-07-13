package velocityventures.mobili.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import velocityventures.mobili.entity.enums.VerificationStatus;



@Entity
@Table(name = "background_checks")
public class BackgroundCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backgroundCheckId;

    private Boolean policeVerified;

    private Boolean identityVerified;

    private Boolean licenseVerified;

    private Boolean criminalRecordStatus;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    private LocalDateTime verificationDate;

    @Column(length = 500)
    private String remarks;

    @OneToOne
    @JoinColumn(name = "application_id", nullable = false, unique = true)
    private DriverApplication driverApplication;

    public BackgroundCheck() {
    }

    
    public BackgroundCheck(Long backgroundCheckId, Boolean policeVerified, Boolean identityVerified,
            Boolean licenseVerified, Boolean criminalRecordStatus, VerificationStatus verificationStatus,
            LocalDateTime verificationDate, String remarks, DriverApplication driverApplication) {
        this.backgroundCheckId = backgroundCheckId;
        this.policeVerified = policeVerified;
        this.identityVerified = identityVerified;
        this.licenseVerified = licenseVerified;
        this.criminalRecordStatus = criminalRecordStatus;
        this.verificationStatus = verificationStatus;
        this.verificationDate = verificationDate;
        this.remarks = remarks;
        this.driverApplication = driverApplication;
    }



    public Long getBackgroundCheckId() {
        return backgroundCheckId;
    }

    public void setBackgroundCheckId(Long backgroundCheckId) {
        this.backgroundCheckId = backgroundCheckId;
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

    public DriverApplication getDriverApplication() {
        return driverApplication;
    }

    public void setDriverApplication(DriverApplication driverApplication) {
        this.driverApplication = driverApplication;
    }

}