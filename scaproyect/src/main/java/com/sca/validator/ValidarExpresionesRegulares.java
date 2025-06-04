package com.sca.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sca.constantes.ExpresionRegular;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ExpresionesRegularesValidador.class)
public @interface ValidarExpresionesRegulares {
	String message() default "El nombre no es válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    String customMessage() default "El nombre no es válido";
    String expresionRegular() default ExpresionRegular.NOMBREAPELLIDO;
}
