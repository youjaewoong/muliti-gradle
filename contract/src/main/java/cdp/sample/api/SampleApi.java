package cdp.sample.api;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cdp.sample.request.CreateSample;
import cdp.sample.request.DeleteSample;
import cdp.sample.request.SampleRequest;
import cdp.sample.request.UpdateSample;
import cdp.sample.urlpath.SampleUrlPath;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "샘플", description = "샘플 테스트")
public interface SampleApi {
	
	@Operation(summary = "샘플 페이지 조회")
	@GetMapping(value = SampleUrlPath.GET_SAMPLE)
	ResponseEntity<?> selectPageSample(@Validated @ParameterObject SampleRequest sampleRequest);

	
	@Operation(summary = "샘플 기본 조회")
	@GetMapping(value = SampleUrlPath.GET_SAMPLE_BASIC)
	ResponseEntity<?> selectBasicSample(@Validated @ParameterObject SampleRequest sampleRequest);
	
	
	@Operation(summary = "샘플 등록")
	@PostMapping(value = SampleUrlPath.POST_SAMPLE)
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<?> insertSample(@Validated @RequestBody CreateSample createSample);
	

	@Operation(summary = "샘플 수정")
	@PutMapping(SampleUrlPath.PUT_SAMPLE)
	ResponseEntity<Integer> updateSample(@Validated @RequestBody UpdateSample updateSample);
	
	
	@Operation(summary = "샘플 삭제")
	@DeleteMapping(SampleUrlPath.DELETE_SAMPLE)
	ResponseEntity<Integer> deleteSample(@Validated @RequestBody DeleteSample deleteSample);


}
