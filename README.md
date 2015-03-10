# DezzyPrint
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

If you are interested in making your own console to print lines, feel free to check out the work I've done and use it as inspiration, or even just to build any other tools you want.

Here are a few examples of how DezzyPrint works, taken straight from the DezzyPrintTutorial class included.

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
		
When the above code is run, the console will display this:
  This is a message with an appended timestamp
  	  >Message Time: 1426027653120
  This is a message with an appended stack trace.
  	  >Message Source: com.gmail.jdesmond10.dezzyprint.main.DezzyPrintTutorial.main(DezzyPrintTutorial.java:29)
  ERROR:  This is a message that utilizes three different string functions, showing how you can chain together as many             different string functions as needed.
  	  >Message Time: 1426027653128
  	  >Message Source: com.gmail.jdesmond10.dezzyprint.main.DezzyPrintTutorial.main(DezzyPrintTutorial.java:32)


