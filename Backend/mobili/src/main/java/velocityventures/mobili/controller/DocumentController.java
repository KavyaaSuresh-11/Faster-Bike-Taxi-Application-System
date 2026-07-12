package velocityventures.mobili.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import velocityventures.mobili.dto.request.DocumentRequest;
import velocityventures.mobili.dto.response.DocumentResponse;
import velocityventures.mobili.service.DocumentService;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload-documents")
    public ResponseEntity<DocumentResponse> uploadDocument(@RequestBody DocumentRequest request){
        return ResponseEntity.ok(documentService.uploadDocument(request));
    }

    @GetMapping("/get-documents/{id}")
    public ResponseEntity<DocumentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.getById(id));
    }

    @GetMapping("/get-documents")
    public ResponseEntity<List<DocumentResponse>> getAllDocuments(){
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @PutMapping("/update-document/{id}")
    public ResponseEntity<DocumentResponse> updateById(@PathVariable Long id, @RequestBody DocumentRequest request){
        return ResponseEntity.ok(documentService.updateById(id,request));
    }
    @PutMapping("/update-document/{id}/approve")
    public ResponseEntity<String> approveDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.approveDocument(id));
    }
    @PutMapping("/update-document/{id}/reject")
    public ResponseEntity<String> rejectDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.rejectDocument(id));
    }
    @PutMapping("/update-document/{id}/withhold")
    public ResponseEntity<String> withholdDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.withholdDocument(id));
    }




    @DeleteMapping("/delete-document/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.deleteById(id));
    }
}
