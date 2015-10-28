/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 * 
 * @author MLB
 * 
 */
public class Code3aGenerator {

	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}

	/**
	 * Generate code for a binary operation like +, -, * and /
	 * @param op must be a code op: Inst3a.TAC.ADD or SUB or MUL or DIV
	 * @param temp a temporary variable which will store the result
	 * @param exp1 the left term of the binary operation
	 * @param exp2 the right term of the binary operation
	 * @return the code3a
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1, ExpAttribute exp2) {
		Code3a code = exp1.code;
		code.append(exp2.code);
		code.append(genVar(temp));
		code.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return code;
	}

	/**
	 * Generate code for a unary operation (negative integers)
	 * @param op must be a code op: Inst3a.TAC.NEG
	 * @param temp a temporary variable which will store the result
	 * @param exp the term of the unary operation
	 * @return the code3a
	 */
	public static Code3a genUnOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp) {
		Code3a code = exp.code;
		code.append(exp.code);
		code.append(genVar(temp));
		code.append(new Inst3a(op, temp, exp.place, null));
		return code;
	}

	/**
	 * Generate code for affectation statement
	 * @param symTab the symbol table
	 * @param exp the expression for the affectation
	 * @param name the name of the variable which will be affected
	 * @return the code3a
	 */
	public static Code3a genAffExpr(SymbolTable symTab, ExpAttribute exp, String name) {
		Operand3a var = symTab.lookup(name);
		
		if(var == null) { // if variable does not exist
			System.err.println("Error, the variable " + name + " does not exist");
			System.exit(-1);
		}

		else {
			if(exp.type.isCompatible(var.type)) { // if variable has correct type
				// COPY -> var = exp.place
				Inst3a inst = new Inst3a(Inst3a.TAC.COPY, var, exp.place, null);
				Code3a code = new Code3a(inst);
				exp.code.append(code);
			}

			else {
				System.err.println("Error, the variable " + name + " has incorrect type : Assignation impossible");
				System.exit(-1);
			}
			
		}
		return exp.code;
	}

	/**
	 * Generate code for variable declaration
	 * @param symTab the symbol table
	 * @param name the name of the variable which will be defined
	 * @return the code3a
	 */
	public static Code3a genDeclVar(SymbolTable symTab, String name) {
		Operand3a var = symTab.lookup(name);
		Code3a code = null;

		if(var != null) { // if the variable already exist
			System.err.println("Error, the variable " + name + " has already been declared");
			System.exit(-1);
		}

		else {
			// Create a VarSymbol of type int with a given name
			var = new VarSymbol(Type.INT, name, symTab.getScope());
			
			// Insert the variable in the symbol table
			symTab.insert(name, var);

			// Generate code3a
			code = genVar(var);
		}

		return code;
	}

	/**
	 * Generate code for label
	 * @param label the label to create
	 * @return the code3a
	 */
	public static Code3a genLabel(LabelSymbol lab) {
		// LABEL -> label lab
		Inst3a inst = new Inst3a(Inst3a.TAC.LABEL, lab, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for if statement
	 * @param exp the expression to evaluate in the if condition
	 * @param label the label to jump to
	 * @return the code3a
	 */
	public static Code3a genIfExpr(ExpAttribute exp, LabelSymbol label) {
		Code3a code = exp.code;

		// IFZ -> ifz exp.place goto label
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, label, null));
		return code;
	}

	/**
	 * Generate code for goto
	 * @param label the label to goto
	 * @return the code3a
	 */
	public static Code3a genGoTo(LabelSymbol label) {
		// GOTO -> goto label
		Inst3a inst = new Inst3a(Inst3a.TAC.GOTO, label, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for arg
	 * @param op the Operand3a which will be the argument
	 * @return the code3a
	 */
	public static Code3a genArg(Operand3a op) {
		// ARG -> arg op
		Inst3a inst = new Inst3a(Inst3a.TAC.ARG, op, null, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for call
	 * @param f the Operand3a which will be called
	 * @return the code3a
	 */
	public static Code3a genCall(Operand3a f) {
		// CALL -> call f
		Inst3a inst = new Inst3a(Inst3a.TAC.CALL, null, f, null);
		Code3a code = new Code3a(inst);
		return code;
	}

	/**
	 * Generate code for print instruction (String only)
	 * @param text the text to print
	 * @return the code3a
	 */
	public static Code3a genPrintString(String text) {
		LabelSymbol printString = SymbDistrib.builtinPrintS;
		Data3a data = new Data3a(text);
		Code3a code = Code3aGenerator.genArg(data.getLabel());
		code.appendData(data);
		code.append(Code3aGenerator.genCall(printString));
		return code;
	}

	/**
	 * Generate code for print instruction (expressions only)
	 * @param exp the expression to print
	 * @return the code3a
	 */
	public static Code3a genPrintExpr(ExpAttribute exp) {
		LabelSymbol printExpr = SymbDistrib.builtinPrintN;
		Code3a code = exp.code;
		code.append(Code3aGenerator.genArg(exp.place));
		code.append(Code3aGenerator.genCall(printExpr));
		return code;

	}

	/**
	 * Generate code for read instruction (ident only)
	 * @param symTab the symbol table
	 * @param name the name of the variable which will be read
	 * @return the code3a
	 */
	public static Code3a genReadIdent(SymbolTable symTab, String name) {
		Code3a code = null;
		Operand3a ident = symTab.lookup(name);
		LabelSymbol readIdent = SymbDistrib.builtinRead;
		if(ident == null) {
			System.err.println("Error, the variable " + name + " does not exist");
			System.exit(-1);
		}

		else {
			code = new Code3a(new Inst3a(Inst3a.TAC.CALL, ident, readIdent, null));
		}
		return code;
	}
} // Code3aGenerator ***