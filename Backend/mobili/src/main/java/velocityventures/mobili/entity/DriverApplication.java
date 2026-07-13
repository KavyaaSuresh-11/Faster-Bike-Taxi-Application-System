package velocityventures.mobili.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import velocityventures.mobili.entity.enums.ApplicationStatus;

@Entity
@Table(name = "driver_application")
public class DriverApplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column
    private LocalDateTime submitted_at;

    @Column
    private LocalDateTime updated_at;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "driverApplication")
    private List<Document> documents;

    @OneToOne(mappedBy = "driverApplication")
    private Vehicle vehicle;

    @OneToOne(mappedBy = "driverApplication",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
private BackgroundCheck backgroundCheck;


    public Long getApplicationId() {
        return applicationid;
    }

    public void setApplicationId(Long applicationid) {
        this.applicationid =applicationid;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(LocalDateTime submitted_at) {
        this.submitted_at = submitted_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DriverApplication() {
    }

    @lombok.Builder
    public DriverApplication(Long applicationid, ApplicationStatus status, String remarks, LocalDateTime submitted_at,
            LocalDateTime updated_at, User user, List<Document> documents, Vehicle vehicle, BackgroundCheck backgroundCheck) {
        this.applicationid = applicationid;
        this.status = status;
        this.remarks = remarks;
        this.submitted_at = submitted_at;
        this.updated_at = updated_at;
        this.user = user;
        this.documents = documents;
        this.vehicle = vehicle;
        this.backgroundCheck = backgroundCheck;
    }

}
