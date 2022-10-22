package cdp.common.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cdp.common.subset.EnumTypeSubset;

@SuppressWarnings("rawtypes")
public class EnumTypeSubsetValidator implements ConstraintValidator<EnumTypeSubset, Enum> {
	private String[] include;
	private String[] exclude;

	@Override
	public void initialize(EnumTypeSubset constraintAnnotation) {
		this.include = constraintAnnotation.include();
		this.exclude = constraintAnnotation.exclude();
	}

	@Override
	public boolean isValid(Enum value, ConstraintValidatorContext context) {
		return (exclude == null || !Arrays.asList(this.exclude).contains(value.name()))
			   && (include == null || Arrays.asList(this.include).contains(value.name()));
	}
}