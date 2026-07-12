package velocityventures.mobili.dto.request;

import org.springframework.boot.security.autoconfigure.SecurityProperties.User;

import jakarta.persistence.Column;

public class ApplicationRequest {
    

    private Long user_id;


    private String remarks;

    public Long getUser_id() {
        return user_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ApplicationRequest(){

    }
    public ApplicationRequest(Long user_id, String remarks) {
        this.user_id = user_id;
        this.remarks = remarks;
    }

    
}
