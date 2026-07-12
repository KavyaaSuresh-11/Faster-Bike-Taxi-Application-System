package velocityventures.mobili.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import velocityventures.mobili.entity.DriverApplication;
import velocityventures.mobili.entity.enums.Document_type;

@Builder
public class DocumentRequest {
    private Long id;

    @Enumerated(EnumType.STRING)
    private Document_type documentType;

    private String documentNumber;
    private String filename;
    private String filepath;
    private Long fileSize;
    private DriverApplication driverApplication;
    private String remarks;
    private LocalDate expiryDate;
    

    public DocumentRequest(Long id, Document_type documentType, String documentNumber, String filename, String filepath,
            Long fileSize, DriverApplication driverApplication, String remarks, LocalDate expiryDate) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.filename = filename;
        this.filepath = filepath;
        this.fileSize = fileSize;
        this.driverApplication = driverApplication;
        this.remarks = remarks;
        this.expiryDate=expiryDate;
    }

    public DocumentRequest(){

    }



    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public DriverApplication getDriverApplication() {
        return driverApplication;
    }

    public void setDriverApplication(DriverApplication driverApplication) {
        this.driverApplication = driverApplication;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
}
