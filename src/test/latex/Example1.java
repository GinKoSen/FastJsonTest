package test.latex;

import java.io.IOException;

/**
 * A class to test LaTeX rendering.
 **/
public class Example1 {
	public static void main(String[] args) {

		String latex = "\\begin";
		latex += "\\frac{d}{dx}c^n=nx^{n-1}";
		latex += "\\end";

		try {
			Convert.toSVG(latex, "Example1.svg", false);
			Convert.toSVG(latex, "Example1_shaped.svg", true);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
