package cdp.sample.request;

import cdp.common.model.SearchCriteria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "샘플 요청")
public class SampleRequest extends SearchCriteria {
	
	@Schema(description = "제목", example = "홍길동")
	private String title;
	
	@Schema(description = "고유ID", example = "1")
	private String id;

}
