package cdp.sample.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "샘플 응답")
public class SampleResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Schema(description = "고유ID", example = "1")
	private int id;

	@Schema(description = "제목", example = "제목 입니다.")
	private String title;
	
	@Schema(description = "내용", example = "내용 입니다.")
	private String contents;
	
	@Schema(description = "타입", example = "APPLY")
	private String type;

	@Schema(description = "작성일", example = "2022-07-20 12:00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime regDt;

	@Schema(description = "수정일", example = "2022-07-20 13:00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime editDt;
}
