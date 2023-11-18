package com.neylandev.delivery.domain.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = TelephoneValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {

    String message() default "O telefone='${validatedValue}' é inválido";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
