package cdp.common.subset;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cdp.common.validator.EnumTypeSubsetValidator;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumTypeSubsetValidator.class)
public @interface EnumTypeSubset {
	String[] include() default {};

	String[] exclude() default {};

	String message() default "must be any of {anyOf}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}