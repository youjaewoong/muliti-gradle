package cdp.sample.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cdp.sample.enums.SampleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "샘플 수정")
public class UpdateSample {
	
	@NotNull(message = "고유ID값은 필수입니다.")
	@Schema(description = "고유ID", example = "1")
	private int id;
	
	@NotEmpty(message = "사용자명은 필수입니다.")
	@Schema(description = "사용자", example = "유관순")
	private String name;
	
	@NotEmpty(message = "제목은 필수입니다.")
	@Schema(description = "제목", example = "변경된 제목 입니다.")
	private String title;

	@NotEmpty(message = "내용은 필수입니다.")
	@Schema(description = "내용", example = "변경된 내용 입니다.")
	private String contents;

	@Schema(description = "타입", example = "APPROVAL" )
	private SampleType type;
}
