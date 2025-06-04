package com.sca.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionUtils {

	private final static String REGEX = "^[A-Z][a-z]*$";
	
	public static boolean validarNombre(String palabra) { 
	        Pattern pattern = Pattern.compile(REGEX);
	        Matcher matcher = pattern.matcher(palabra);
	        
	        if (matcher.matches()) {
	            return true;
	        } else {
	            return false;
	        }
	}
}
