package cdp.sample.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SampleType implements GenericEnum<Integer> {
	
	APPLY(1, "접수"),
	APPROVAL(2, "승인");

	private Integer value;
	private String description;

	SampleType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
