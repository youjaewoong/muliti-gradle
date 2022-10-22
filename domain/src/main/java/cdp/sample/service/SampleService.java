package cdp.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cdp.common.model.ListResponse;
import cdp.common.model.PageResponse;
import cdp.common.util.PageUtils;
import cdp.sample.mapper.SampleMapper;
import cdp.sample.request.CreateSample;
import cdp.sample.request.DeleteSample;
import cdp.sample.request.SampleRequest;
import cdp.sample.request.UpdateSample;
import cdp.sample.response.SampleResponse;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SampleService {
	
	private final SampleMapper sampleMapper;

	/**
	 * 페이지 조회
	 */
	public PageResponse<SampleResponse> selectPageSample(SampleRequest sampleRequest) {
		
		// 페이징 처리 시
		PageUtils.setPageable(sampleRequest);
		List<SampleResponse> response = sampleMapper.selectSample(sampleRequest);
		return new PageResponse<SampleResponse>(response, sampleRequest);
	}

	
	/**
	 * 일반 조회
	 */
	public ListResponse<SampleResponse> selectBasicSample(SampleRequest sampleRequest) {
		
		List<SampleResponse> response = sampleMapper.selectSample(sampleRequest);
		return new ListResponse<SampleResponse>(response);
	}
	
	
	/**
	 * 수정
	 */
	public int updateSample(UpdateSample updateSample) {
		
		return sampleMapper.updateSample(updateSample);
	}


	/**
	 * 추가
	 */
	public void insertSample(CreateSample createSample) {
		
		sampleMapper.insertSample(createSample);
	}

	
	/**
	 * 삭제
	 */
	public int deleteSample(DeleteSample deleteSample) {
		
		return sampleMapper.deleteSample(deleteSample);
	}
	
}
