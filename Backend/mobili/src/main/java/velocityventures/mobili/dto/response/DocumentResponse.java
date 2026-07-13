package velocityventures.mobili.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import velocityventures.mobili.entity.enums.Document_type;
import velocityventures.mobili.entity.enums.VerificationStatus;

@Builder
public class DocumentResponse {
    private Long id;

private Document_type documentType;

private String documentNumber;

private VerificationStatus verificationStatus;

private LocalDateTime verificationDate;

private LocalDate expiryDate;

public DocumentResponse(){

}


public DocumentResponse(Long id, Document_type documentType, String documentNumber,
        VerificationStatus verificationStatus, LocalDateTime verificationDate, LocalDate expiryDate) {
    this.id = id;
    this.documentType = documentType;
    this.documentNumber = documentNumber;
    this.verificationStatus = verificationStatus;
    this.verificationDate = verificationDate;
    this.expiryDate = expiryDate;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Document_type getDocumentType() {
    return documentType;
}

public void setDocumentType(Document_type documentType) {
    this.documentType = documentType;
}

public String getDocumentNumber() {
    return documentNumber;
}

public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
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

public LocalDate getExpiryDate() {
    return expiryDate;
}

public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
}


}
