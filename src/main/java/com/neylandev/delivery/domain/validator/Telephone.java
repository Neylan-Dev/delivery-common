package com.neylandev.delivery.domain.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TelephoneValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {

    String message() default "O telefone='${validatedValue}' é inválido";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
