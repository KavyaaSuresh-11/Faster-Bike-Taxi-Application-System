package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.ApplicationRequest;
import velocityventures.mobili.dto.response.ApplicationResponse;

public interface ApplicationService {
    
   ApplicationResponse createApplication(ApplicationRequest request);
   List<ApplicationResponse> getAllApplications();
   ApplicationResponse getApplicationById(Long id);
   ApplicationResponse updateById(Long id, ApplicationRequest request);
   String deleteById(Long id);
   String approveApplication(Long id);
   String rejectApplication(Long id);
   String withholdApplication(Long id);
}
