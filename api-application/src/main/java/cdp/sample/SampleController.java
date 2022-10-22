package cdp.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cdp.common.model.ListResponse;
import cdp.common.model.PageResponse;
import cdp.sample.api.SampleApi;
import cdp.sample.request.CreateSample;
import cdp.sample.request.DeleteSample;
import cdp.sample.request.SampleRequest;
import cdp.sample.request.UpdateSample;
import cdp.sample.response.SampleResponse;
import cdp.sample.service.SampleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleController implements SampleApi {
	
	private final SampleService sampleService;
	
	
	@Override
	public ResponseEntity<?> selectPageSample(SampleRequest sampleRequest) {
		
		PageResponse<SampleResponse> response = sampleService.selectPageSample(sampleRequest);
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public ResponseEntity<?> selectBasicSample(SampleRequest sampleRequest) {
		
		ListResponse<SampleResponse> response = sampleService.selectBasicSample(sampleRequest);
		return ResponseEntity.ok(response);
	}
	

	@Override
	public ResponseEntity<?> insertSample(CreateSample createSample) {
		
		sampleService.insertSample(createSample);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Integer> deleteSample(DeleteSample deleteSample) {
		
		int response = sampleService.deleteSample(deleteSample);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Integer> updateSample(UpdateSample updateSample) {
		
		int response = sampleService.updateSample(updateSample);
		return ResponseEntity.ok(response);
	}

}
