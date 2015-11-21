import org.antlr.runtime.tree.CommonTree;

/**
 * Type checking operations (NOTE: this class must be implemented by the
 * student; the methods indicated here can be seen as suggestions; note that
 * some minor checks can still be performed directly in VSLTreeParser.g).
 * 
 */
public class TypeCheck {

	// an Example
	/**
	 * Type checking for a binary operation - in VSL+: integer operations only!
	 */
	public static Type checkBinOp(Type t1, Type t2) {
		if (t1 == Type.INT && t2 == Type.INT)
			return Type.INT;
		else {
			return Type.ERROR;
		}
	}

	/**
	 * Type checking for a unary operation (Integer only)
	 */
	public static Type checkUnOp(Type t) {
		if (t == Type.INT)
			return Type.INT;
		else {
			return Type.ERROR;
		}
	}

	/**
	 * Type checking for a variable declaration (Integer only)
	 */
	public static Type checkDeclType(Type t) {
		if(t == Type.INT) {
			return Type.INT;
		}
		else {
			return Type.ERROR;
		}
	}

	/**
	 * Checks if the type is Integer
	 */
	public static boolean checkTypeInt(Type t) {
		if (t == Type.INT)
			return true;
		else {
			return false;
		}
	}

	/**
	 * Checks if variable is defined
	 */
	public static Operand3a checkVarDefined(SymbolTable symTab, String name, CommonTree t) {
		Operand3a var = symTab.lookup(name);
		
		if(var == null) { // if variable does not exist
			Errors.unknownIdentifier(t, name, null);
			System.exit(-1);
		}

		return var;
	}
}
