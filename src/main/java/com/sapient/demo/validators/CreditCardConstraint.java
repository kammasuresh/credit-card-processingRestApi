package com.sapient.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CreditCardValidator.class)
@Target({ ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditCardConstraint {

    String message() default "Invalid Credit Card number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
