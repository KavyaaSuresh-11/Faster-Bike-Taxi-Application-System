package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import velocityventures.mobili.dto.request.DocumentRequest;
import velocityventures.mobili.dto.response.DocumentResponse;
import velocityventures.mobili.entity.Document;
import velocityventures.mobili.entity.DriverApplication;
import velocityventures.mobili.entity.enums.Document_type;
import velocityventures.mobili.entity.enums.VerificationStatus;
import velocityventures.mobili.repository.DocumentRepository;
import velocityventures.mobili.repository.DriverApplicationRepository;
import velocityventures.mobili.service.DocumentService;

@Service
public class DocumentImpl implements DocumentService {
    @Autowired
        private DriverApplicationRepository driverRepo;

        @Autowired
        private DocumentRepository documentRepo;
        
    
    @Override
    public DocumentResponse uploadDocument(DocumentRequest request){

        DriverApplication application = driverRepo.findById(request.getId()).orElseThrow(()-> new RuntimeException("No Application found!"));

        Document document = Document.builder()
        .documentNumber(request.getDocumentNumber())
        .documentType(request.getDocumentType())
        .driverApplication(application)
        .fileName(request.getFilename())
        .fileSize(request.getFileSize())
        .filePath(request.getFilepath())
        .expiryDate(request.getExpiryDate())
        .uploadDate(LocalDateTime.now())
        .verificationDate(null)
        .verificationStatus(VerificationStatus.PENDING)
        .remarks(request.getRemarks()).build();
        Document saved = documentRepo.save(document);

        return DocumentResponse.builder()
        .documentNumber(saved.getDocumentNumber())
        .documentType(saved.getDocumentType())
        .expiryDate(saved.getExpiryDate())
        .id(saved.getId())
        .verificationDate(saved.getVerificationDate())
        .verificationStatus(saved.getVerificationStatus())
        .build();
    }
@Override
    public DocumentResponse getById(Long id){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("No Documents Exists!"));
        return DocumentResponse.builder()
        .documentNumber(document.getDocumentNumber())
        .documentType(document.getDocumentType())
        .expiryDate(document.getExpiryDate())
        .id(document.getDriverApplication().getApplicationId())
        .verificationStatus(document.getVerificationStatus())
        .verificationDate(document.getVerificationDate())
        .build();
    }

@Override
    public List<DocumentResponse> getAllDocuments(){
        List<Document> overall = documentRepo.findAll();
        List<DocumentResponse> list = new ArrayList<>();
        for(Document document : overall){
            DocumentResponse response = DocumentResponse.builder()
            .documentNumber(document.getDocumentNumber())
            .documentType(document.getDocumentType())
            .expiryDate(document.getExpiryDate())
            .id(document.getDriverApplication().getApplicationId())
            .verificationDate(document.getVerificationDate())
            .verificationStatus(document.getVerificationStatus())
            .build();
            list.add(response);
        }
        return list;
    }

    @Override
    public DocumentResponse updateById(Long id, DocumentRequest request){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("Document not found!"));
        document.setDocumentType(request.getDocumentType());
        document.setExpiryDate(request.getExpiryDate());
        document.setFileName(request.getFilename());
        document.setFileSize(request.getFileSize());
        document.setFilePath(request.getFilepath());
        Document saved = documentRepo.save(document);
        return DocumentResponse.builder()
        .documentNumber(saved.getDocumentNumber())
        .documentType(saved.getDocumentType())
        .expiryDate(saved.getExpiryDate())
        .verificationDate(saved.getVerificationDate())
        .verificationStatus(saved.getVerificationStatus())
        .build();
    }

    @Override
    public String deleteById(Long id){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("Document not found!"));
        documentRepo.deleteById(id);
        return "Document successfully deleted";
    }
    @Override
    public String approveDocument(Long id){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("Document not found"));
        document.setVerificationStatus(VerificationStatus.APPROVED);
        document.setVerificationDate(LocalDateTime.now());
        documentRepo.save(document);
        return "Document approved successfully";
    }
     @Override
    public String rejectDocument(Long id){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("Document not found"));
        document.setVerificationStatus(VerificationStatus.REJECTED);
        document.setVerificationDate(LocalDateTime.now());
        documentRepo.save(document);
        return "Document rejected";
    }
     @Override
    public String withholdDocument(Long id){
        Document document = documentRepo.findById(id).orElseThrow(()-> new RuntimeException("Document not found"));
        document.setVerificationStatus(VerificationStatus.WITH_HOLD);
        document.setVerificationDate(LocalDateTime.now());
        documentRepo.save(document);
        return "Document withheld";
    }
}
