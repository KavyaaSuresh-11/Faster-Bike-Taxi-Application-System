package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.BackgroundCheckRequest;
import velocityventures.mobili.dto.response.BackgroundCheckResponse;

public interface BackgroundCheckService {

    BackgroundCheckResponse performBackgroundCheck(BackgroundCheckRequest request);

    List<BackgroundCheckResponse> getAll();

    BackgroundCheckResponse getById(Long id);

    BackgroundCheckResponse getByApplicationId(Long applicationId);

}
