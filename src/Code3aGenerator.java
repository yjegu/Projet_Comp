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
	 * Generate code for a binary operation
	 * 
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1,
			ExpAttribute exp2) {
		Code3a cod = exp1.code;
		cod.append(exp2.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return cod;
	}

	/**
	 * Generate code for a unary operation
	 * 
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genUnOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp) {
		Code3a cod = exp.code;
		cod.append(exp.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp.place, null));
		return cod;
	}

	/**
	 * Generate 3a Code for assignation of a variable
	 */
	public static Code3a genAssignExpr(SymbolTable symTab, ExpAttribute exp, String name) {
		Operand3a var = symTab.lookup(name);
		if(var == null) {
			System.err.println("Error, the variable " + name + " does not exist");
			System.exit(-1);
		}

		else {
			if(exp.type.isCompatible(var.type)) {
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
	 * Generate 3a Code for declaration of a variable
	 */
	public static Code3a genDeclVar(SymbolTable symTab, String name) {
		Operand3a var = symTab.lookup(name);
		Code3a code = null;

		if(var != null) {
			System.err.println("Error, the variable " + name + " has already been declared");
			System.exit(-1);
		}

		else {
			var = new VarSymbol(Type.INT, name, symTab.getScope());
			symTab.insert(name, var);
			code = genVar(var);
		}

		return code;
	}

} // Code3aGenerator ***
