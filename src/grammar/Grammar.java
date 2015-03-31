package grammar;

/**
 * DO NOT MODIFY
 */
public class Grammar {
	/**
	 * Grammar
	 * E -> E + T
	 * E -> E - T
	 * E -> T
	 * T -> T * F
	 * T -> T / F
	 * T -> F
	 * F -> ( E )
	 * F -> id
	 * id -> "0" | ("1"-"9") {"0"-"9"}
	 */
	
	public final static String PLUS = "+";
	public final static String MINUS = "-";
	public final static String TIMES = "*";
	public final static String DIVIDE = "/";
	public final static String LEFTPAR = "(";
	public final static String RIGHTPAR = ")";
	
}
