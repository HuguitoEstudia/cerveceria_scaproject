package com.sca.constantes;

public class ExpresionRegular {

	public static final String NOMBREAPELLIDO = "^[A-Z][a-z]*$"; // Solo permite que la primera sea mayuscula y las demás minusculas y no admite otro caracter o número
	public static final String DOCUMENTO = "(?:\\d{1,3}(?:\\.\\d{3})*(?:\\.\\d{1,3})?|\\d{1,9})$"; // Permite valores de miles separado con un punto cada o numeros con un maximo de 9 caracteres parael dni
	public static final String FECHA = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$"; // Valida una fecha en formato dd/mm/aaaa
	public static final String CUIT = "^\\d{2}-\\d{8}-\\d|\\d{1,9}$"; // Valida que el cuit este en formato xx-xxxxxxxx-x o sean numeros
	public static final String TELEFONO = "^\\(\\d{3}\\) \\d{3}-\\d{4}$"; // Valida que el telefono se valide en formato (xxx) xxx-xxxx
	public static final String LEGAJO = "^\\d{3}$"; // Valida que el legajo tenga 3 digitos	
}
