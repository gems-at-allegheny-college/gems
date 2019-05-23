package jgrader.parse;

import jgrader.parse.objects.CompileErrorParseObject;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

public class CompileErrorParser extends Parser<Diagnostic<? extends JavaFileObject>, CompileErrorParseObject> {

	int numErrors;

	public CompileErrorParser() {
		numErrors = 0;
	}

	public String complete() {
		if (numErrors > 0) {
			return "FAILED! There were " + numErrors + " errors!";
		} else {
			return "SUCCESS! There were no errors!";
		}
	}

	public CompileErrorParseObject parse(Diagnostic<? extends JavaFileObject> diag) {

		//simple print for now
		System.out.println("Code: " + diag.getCode());
		System.out.println("Kind: " + diag.getKind());
		System.out.println("Position: " + diag.getPosition());
		System.out.println("Start Position: " + diag.getStartPosition());
		System.out.println("End Position: " + diag.getEndPosition());
		System.out.println("Source: " + diag.getSource());
		System.out.println("Message: " + diag.getMessage(null));

		//do parsing
		CompileErrorParseObject error = new CompileErrorParseObject("", "", diag.getMessage(null));

		return error;
	}
}
