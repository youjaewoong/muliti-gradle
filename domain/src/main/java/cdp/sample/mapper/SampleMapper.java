package cdp.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cdp.sample.request.CreateSample;
import cdp.sample.request.DeleteSample;
import cdp.sample.request.SampleRequest;
import cdp.sample.request.UpdateSample;
import cdp.sample.response.SampleResponse;

@Mapper
public interface SampleMapper {
	
	List<SampleResponse> selectSample(SampleRequest sampleResponse);

	int updateSample(UpdateSample updateSample);

	void insertSample(CreateSample createSample);

	int deleteSample(DeleteSample deleteSample);

}
