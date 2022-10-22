package cdp.sample.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "샘플 삭제")
public class DeleteSample {
	
	@NotEmpty(message = "게시글 번호는 필수입니다.")
	@Schema(description = "게시글 번호", allowableValues = "1")
	private List<String> ids;
}
