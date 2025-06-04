package com.sca.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExpresionesRegularesValidador implements ConstraintValidator<ValidarExpresionesRegulares, String> {

	private String customMessage;
	private String regex;

	@Override
	public void initialize(ValidarExpresionesRegulares validarNombreYApellido) {
		customMessage = validarNombreYApellido.customMessage();
		regex = validarNombreYApellido.expresionRegular();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Realiza tus validaciones aquí
		if (value == null || !value.matches(regex)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(customMessage).addConstraintViolation();
			return false;
		}
		return true;
	}

}
