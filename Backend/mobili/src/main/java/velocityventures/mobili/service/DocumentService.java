package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.DocumentRequest;
import velocityventures.mobili.dto.response.DocumentResponse;

public interface DocumentService {
    DocumentResponse uploadDocument(DocumentRequest request);
    DocumentResponse getById(Long id);
    List<DocumentResponse> getAllDocuments();
    DocumentResponse updateById(Long id, DocumentRequest request);
    String deleteById(Long id);
    String approveDocument(Long id);
    String rejectDocument(Long id);
    String withholdDocument(Long id);
}
