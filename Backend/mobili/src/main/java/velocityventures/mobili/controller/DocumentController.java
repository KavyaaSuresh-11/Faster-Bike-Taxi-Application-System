package velocityventures.mobili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import velocityventures.mobili.dto.request.DocumentRequest;
import velocityventures.mobili.dto.response.DocumentResponse;
import velocityventures.mobili.service.DocumentService;

@RestController
@Tag(name = "Document Management", description = "APIs for uploading and verifying documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload-documents")
    @Operation(summary = "Upload a document")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document uploaded successfully"),
        @ApiResponse(responseCode = "404", description = "Application not found")
    })
    public ResponseEntity<DocumentResponse> uploadDocument(@RequestBody DocumentRequest request){
        return ResponseEntity.ok(documentService.uploadDocument(request));
    }

    @GetMapping("/get-documents/{id}")
    @Operation(summary = "Get document by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document found"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<DocumentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.getById(id));
    }

    @GetMapping("/get-documents")
    @Operation(summary = "Get all documents")
    @ApiResponse(responseCode = "200", description = "List of all documents")
    public ResponseEntity<List<DocumentResponse>> getAllDocuments(){
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @PutMapping("/update-document/{id}")
    @Operation(summary = "Update document by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document updated successfully"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<DocumentResponse> updateById(@PathVariable Long id, @RequestBody DocumentRequest request){
        return ResponseEntity.ok(documentService.updateById(id,request));
    }
    @PutMapping("/update-document/{id}/approve")
    @Operation(summary = "Approve a document")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document approved"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<String> approveDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.approveDocument(id));
    }
    @PutMapping("/update-document/{id}/reject")
    @Operation(summary = "Reject a document")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document rejected"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<String> rejectDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.rejectDocument(id));
    }
    @PutMapping("/update-document/{id}/withhold")
    @Operation(summary = "Withhold a document")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document withheld"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<String> withholdDocument(@PathVariable Long id){
        return ResponseEntity.ok(documentService.withholdDocument(id));
    }




    @DeleteMapping("/delete-document/{id}")
    @Operation(summary = "Delete a document")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Document deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Document not found")
    })
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.deleteById(id));
    }
}
