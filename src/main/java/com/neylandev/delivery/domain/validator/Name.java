package com.neylandev.delivery.domain.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = NameValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {

    String message() default "O nome='${validatedValue}' não pode conter caracteres especiais ou números, ou conter 4 caracteres iguais em sequencia";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
