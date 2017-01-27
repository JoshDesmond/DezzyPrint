package com.gmail.jdesmond10.dezzyprint.main;

/**
 * A Collection of different StringFunctions that are included. For uses of
 * these StringFunctions, see {@link DezzyPrintTutorial}. Every instance of
 * StringFunctions is a StringFunction, and can be used as so.
 * 
 * @author Josh Desmond
 *
 */
public enum StringFunctions implements StringFunction {

	/**
	 * Appends a message with a source of the message.
	 */
	TRACE((final String s) -> {
		final StackTraceElement methodLocation = Thread.currentThread()
				.getStackTrace()[4];

		return s + "\n	>Message Source: " + methodLocation;
	}),

	/**
	 * Appends a message with the system time in milliseconds. Useful for
	 * measuring the time between two messages.
	 */
	TIME((final String s) -> {

		return String.format("%s\n	>Message Time: %s", s,
				System.currentTimeMillis());
	}),

	/**
	 * Prefaces a message with "ERROR:  "
	 */
	PREFACE_ERROR((final String s) -> {
		return String.format("ERROR:  %s", s);
	});

	/**
	 * This is the only field that an ENUM in StringFunctions will have. These
	 * are defined above in the constructors.
	 */
	private StringFunction f;

	/**
	 * Constructor for the ENUM.
	 * 
	 * @param function
	 *            The StringFunction (functional interface) with which a value
	 *            in StringFunctions is going to use.
	 */
	private StringFunctions(final StringFunction function) {
		this.f = function;
	}

	@Override
	public String apply(final String string) {
		return f.apply(string);
	}
}
