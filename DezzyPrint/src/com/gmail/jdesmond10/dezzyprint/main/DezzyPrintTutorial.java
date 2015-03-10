package com.gmail.jdesmond10.dezzyprint.main;

/**
 * A Class included only for demonstration of how to use DezzyPrint.
 * 
 * @author Josh Desmond
 * 
 */
public class DezzyPrintTutorial {

	public static void main(final String[] args) {

		/*
		 * DezzyPrint is a library which utilizes some of the newest features in
		 * Java (such as functional interfaces released in Java 8), and also
		 * enables a more customizable printing utility. With DezzyPrint, you
		 * can very easily customize your messages, either by adding a time
		 * stamp, a stack trace stamp, or add your own customized functions to
		 * apply to printed statements.
		 * 
		 * DezzyPrint also allows for a replaceable PrintStream. With one line
		 * of code, all of your Printer.println() statements can be printing to
		 * your own customized console.
		 */

		Printer.println("This is a message with an appended timestamp",
				StringFunctions.TIME);

		Printer.println("This is a message with an appended stack trace.",
				StringFunctions.TRACE);

		Printer.println(
				"This is a message that utilizes three different string "
						+ "functions, showing how you can chain together as many "
						+ "different string functions as needed.",
						StringFunctions.PREFACE_ERROR, StringFunctions.TIME,
						StringFunctions.TRACE);

		/*
		 * Here we are setting the printStream to null, meaning no messages will
		 * be shown from then on. This feature can also be used to allow for
		 * customized printStreams.
		 */
		Printer.setPrintStream(null);
		Printer.println("This message will not print to the console.");

	}
}
