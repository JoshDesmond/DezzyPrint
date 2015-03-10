package com.gmail.jdesmond10.dezzyprint.main;

import java.util.function.Function;

/**
 * A function that takes a String, modifies it, and returns the modified String.
 * 
 * @author Josh Desmond
 *
 */
@FunctionalInterface
public interface StringFunction extends Function<String, String> {

	@Override
	public String apply(String string);

}
