package velocityventures.mobili.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import velocityventures.mobili.entity.enums.Document_type;
import velocityventures.mobili.entity.enums.VerificationStatus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
private Document_type documentType;


private String documentNumber;

private String fileName;

private String filePath;

private Long fileSize;

private LocalDateTime uploadDate;

@Enumerated(EnumType.STRING)
private VerificationStatus verificationStatus;

private LocalDateTime verificationDate;

private LocalDate expiryDate;

private String remarks;

@ManyToOne
@JoinColumn(name = "application_id")
private DriverApplication driverApplication;
}
