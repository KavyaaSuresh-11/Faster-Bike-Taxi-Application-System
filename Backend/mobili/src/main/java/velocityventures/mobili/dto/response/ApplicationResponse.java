package velocityventures.mobili.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import velocityventures.mobili.entity.enums.ApplicationStatus;

@Builder
public class ApplicationResponse {
     private Long applicationId;

    private Long userId;

    private ApplicationStatus status;

    private String remarks;

    private LocalDateTime submittedAt;

    private LocalDateTime updatedAt;
    public ApplicationResponse(){

    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ApplicationResponse(Long applicationId, Long userId, ApplicationStatus status, String remarks,
            LocalDateTime submittedAt, LocalDateTime updatedAt) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.status = status;
        this.remarks = remarks;
        this.submittedAt = submittedAt;
        this.updatedAt = updatedAt;
    }

    
    
}
