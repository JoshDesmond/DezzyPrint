package com.gmail.jdesmond10.dezzyprint.main;

import java.io.PrintStream;
import java.util.Optional;

/**
 * A custom class that has a method to replace system.out.println() commands.
 * Printer is a static class and never needs to be initiated.
 * 
 * @author Josh Desmond
 * @version 1.0
 */
public class Printer {

	/**
	 * The PrintStream to print to (default value if not specified is
	 * System.out)
	 */
	private static Optional<PrintStream> pStream = Optional.of(System.out);

	/**
	 * Prints the given message to the current PrintStream.
	 * 
	 * @param string
	 *            The message to be printed in a new line.
	 */
	public static void println(final String string) {
		// Calls println but using a nullable optional.
		println(string, s -> s);
	}

	/**
	 * Prints the given message to the current PrintStream, and applies the
	 * given StringFunctions in order.
	 * 
	 * Note the importance that
	 * 
	 * @param string
	 *            The message to be printed in a new line.
	 * @param function
	 *            The function to be applied to the given String before being
	 *            printed. For a list of pre-written functions, see
	 *            {@link StringFunctions}.
	 */
	public static void println(String string, final StringFunction... function) {
		// Validates that there is a PrintStream before processing the String
		if (!pStream.isPresent())
			return;

		for (final StringFunction stringFunction : function) {
			string = stringFunction.apply(string);
		}

		print(string);

	}

	/**
	 * Prints the given message to the current PrintStream.
	 * 
	 * @param string
	 *            The message to be printed in a new line.
	 */
	private static void print(final String string) {
		// Prints to the PrintStream if and only if it is present.
		pStream.ifPresent((final PrintStream p) -> (p.println(string)));

	}

	/**
	 * Changes the PrintStream where messages will be printed. Null values will
	 * disable all printing.
	 * 
	 * @param printStream
	 */
	public static void setPrintStream(final PrintStream printStream) {
		pStream = Optional.ofNullable(printStream);
	}

}
