package cdp.common.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class SearchCriteria {

	@Min(1)
	@Schema(description = "페이지", example = "1")
	private int page = 1;

	@Min(-1)
	@Max(10000)
	@Schema(description = "사이즈", example = "10")
	private int size = 10;
	
}