import java.io.*;

/**
 * This class handles the generation of C code from the interpreter/compiler.
 * It writes a C source file, incorporating the parsed code within a basic C program structure.
 */
public class Code {

	// The prologue contains standard C headers and the main function definition.
	private final String[] prologue={
		"#include <stdio.h>",
		"int main() {",
	};

	// The epilogue closes the main function and ensures proper program termination.
    private final String[] epilogue={
		"return 0;",
		"}",
	};

	/**
     * Constructs a Code object that generates a C program file.
     * @param code The translated source code to be embedded in the C file.
     * @param env The environment containing variable declarations for C translation.
     */
    public Code(String code, Environment env) {
		String fn=System.getenv("Code");
		if (fn==null)
			return;
		try {
			BufferedWriter f=new BufferedWriter(new FileWriter(fn+".c"));
			for (String s: prologue)
				f.write(s+"\n");
			f.write(env.toC());
			f.write(code);
			for (String s: epilogue)
				f.write(s+"\n");
			f.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
